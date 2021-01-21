package luongnvpk.repository;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.transaction.Transaction;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Table;
import org.hibernate.id.GUIDGenerator;

import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;

import luongnvpk.helper.HibernateUtil;
import luongnvpk.helper._C;
import luongnvpk.model.AccountStaff;
import luongnvpk.model.BaseModel;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;

public class BaseRepository<T extends BaseModel> {
	Class Repoclass = null;
	protected String name= "";
	public static Session session; 
	
	public Session getSession() {
		if(session == null) {
			this.session = HibernateUtil.settingDbHelper(this.Repoclass).openSession();
		}
		return this.session;
	}
	
	protected String querySearch(String search , String[] searchFiled) {
		String querySearch = "1=1";
		int length = 0;
		if(searchFiled !=null) {
			length = searchFiled.length;
		}
		for (int i=0;i< length; i++) {
			String feild = searchFiled[i];
			if(i==0) {
				querySearch = (""+feild + " like '%" +search + "%'");				
			}
			if(i==searchFiled.length-1) {
				querySearch += (" or "+feild + " like '%" +search + "%'");
			}
			else {
				querySearch += (" or "+feild + " like '%" +search + "%'");
			}
		}
		return querySearch;
	}
	
	protected String queryFilter(Object query) {
		return "";
	}
	
	protected String querySort(String[] sort) {
		String querySort = "";
		int lenght= 0 ;
		if(sort != null) {
			lenght = sort.length;
			querySort = " order by ";
		}
		for(int i =0 ; i < lenght ; i++) {
			if(sort[i].startsWith("-")) {
				if(i==0) {
					querySort +=  sort[i].substring(1)+ " DESC ";
				}
				else querySort +=(" , " + sort[i].substring(1)+ " DESC ");
			}
			else {
				if(i==0) {
					querySort +=  sort[i]+ " ASC ";
				}
				else querySort +=(" , " + sort[i]+ " ASC ");
			}
		}
		return querySort;
	}

	protected List<T>  executeFind(String sql, FindFilter filter ){
		String queryMain = "where (1=1)";
		String querySearch = this.querySearch(filter.getSearch(), filter.getSearchFileds());
		String querySort = this.querySort(filter.getSorts());
		queryMain += (" and ("+querySearch+")");
		String newSql = "select * from ("+ sql + ") as querySQL "
				+ queryMain + " "
				+ querySort + " ";
		@SuppressWarnings("deprecation")
		Query<T> query =  this.getSession().createNativeQuery(newSql, this.Repoclass);
		query.setMaxResults(filter.getLimit());
		query.setFirstResult(filter.getOffset());
		return query.getResultList();
	}
	
	protected int executeCount(String sql, FindFilter filter ) {
		String queryMain = "where (1=1)";
		String querySearch = this.querySearch(filter.getSearch(), filter.getSearchFileds());

		queryMain += (" and ("+querySearch+")");
		String newSql = "select count(*) from ("+ sql + ") as querySQL "
				+ queryMain + " ";
		Query<T> query =  this.getSession().createNativeQuery(newSql);
		return  Integer.valueOf(String.valueOf(query.getSingleResult()).toString().trim());
	}
	
	public FindFilter convertListPropsToFindProps(ListFilter filter) {
		FindFilter findFiler = new FindFilter();
		findFiler.setSearch(filter.getSearch());
		findFiler.setSearchFiled(filter.getSearchFiled());
		findFiler.setSort(filter.getSort());
		findFiler.setOffset((filter.getPage()-1) * filter.getPageSize());
		findFiler.setLimit(filter.getPageSize());
		return findFiler;
	}
	
	protected Paging<T>  executeList(String sql, ListFilter filter){
		
		List<T> list =  this.executeFind(sql, this.convertListPropsToFindProps(filter));
		int total = this.executeCount(sql, this.convertListPropsToFindProps(filter)); 
		Paging<T> pagingList = new Paging<T>();
		pagingList.setPage(filter.getPage());
		pagingList.setPageSize(filter.getPageSize());
		pagingList.setTotal(total);
		pagingList.setTotalPages((int) Math.round(Math.ceil((double)total/(double)filter.getPageSize())));
		pagingList.setRows(list);;
		return pagingList;
	}
	
	public Paging<T> list(ListFilter filter) {
		String sql = "select * from "+this.name+" where is_deleted=0";
		return this.executeList(sql, filter);
	}
	
	public List<T> find(FindFilter filter) {		
		String sql = "select * from "+this.name+" where is_deleted=0";
		return this.executeFind(sql, filter);
	}
		
	protected T defaultValueSave(T t) {
		UUID uuid = Generators.randomBasedGenerator().generate();	
		t.setId(_C.value(t.getId(), uuid.toString()));
		t.setCreatedAt(new Date());
		t.setIsDeleted(false);
		t.setUpdatedAt(_C.value(t.getUpdatedAt(), new Date()));
		t.setUpdatedBy("admin");
		t.setCreatedBy("admin");
		return t;
	}
	
	public T save(T t) {
		Session session = this.getSession();
		session.beginTransaction();
		t= this.defaultValueSave(t);
		if(t.getId()!= null && t.getId().toString().trim() != "") {
			T checkExist = this.get(t.getId());
			if(checkExist!= null) {
				session.save(checkExist);
				session.evict(t);
				session.merge(t);
				session.getTransaction().commit();
				return t;
			}
		}
		t= this.defaultValueSave(t);
		t.setIsDeleted(false);
		session.save(t);
		session.getTransaction().commit();
		return this.get(t.getId());
	}
	
	public T remove(String id) {
		Session session = this.getSession();
		session.beginTransaction();
		if(id!= null && id.toString().trim() != "") {
			T checkExist = this.get(id);
			if(checkExist!= null) {
				System.out.println(checkExist.getId());
				checkExist.setIsDeleted(true);
				session.save(checkExist);
				session.evict(checkExist);
				session.getTransaction().commit();
				return checkExist;
			}
		}
		return null;
	}
	
	public T get(String id) {
		Query<T> query = this.getSession().createNativeQuery("select * from "+this.name+" where is_deleted=0 and id = :id", Repoclass);
		query.setParameter("id", id);
		T t;
		try {
			t =  query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return t;
	}
	
	public List<T> get(String[] id) {
		@SuppressWarnings({ "deprecation", "unchecked" })
		Query<T> query = this.getSession().createNativeQuery("select * from "+this.name+" where is_deleted=0 and id = :id", Repoclass);
		query.setParameter("id", id);
		return query.getResultList();
	}
}
