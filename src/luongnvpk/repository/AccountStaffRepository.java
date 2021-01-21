package luongnvpk.repository;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

import luongnvpk.helper.AuthenHelper;
import luongnvpk.helper.HibernateUtil;
import luongnvpk.helper.ObjectHelper;
import luongnvpk.model.AccountStaff;
import luongnvpk.model.BaseModel;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;

public class AccountStaffRepository extends BaseRepository<AccountStaff>{
	
	public AccountStaffRepository() {
		super();
		super.Repoclass = AccountStaff.class;
		super.name = "account_staff";
	}
	public String login(String name , String password) {
		Query<AccountStaff> query =  this.getSession().createNativeQuery("select * from "+this.name+" where is_deleted=0 and username =:username and password = :password", this.Repoclass);
		query.setParameter("username", name);
		query.setParameter("password", password);
		try {
			String get = ObjectHelper.gson().toJson(query.getResultList().get(0));
			System.out.println(get);
			String token =  AuthenHelper.signJwt(get);
			AuthenHelper.veryJWT(get, token);
			return token;
		} catch (Exception e) {
			System.out.println(e);
			return "errorJWT";
		}
	}
}
