package luongnvpk.model.filter;

import java.util.Arrays;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class BaseFilter {
	String  search = "";
	String searchFiled = "";
	Object query = new Object();
	FilterProps[] filter;
	public BaseFilter(String search, String searchFiled) {
		super();
		this.search = search;
		this.searchFiled = searchFiled;
	}
	public BaseFilter() {
		super();
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchFiled() {
		return searchFiled;
	}
	public void setSearchFiled(String searchFiled) {
		this.searchFiled = searchFiled;
	}
	
	
	public Object getQuery() {
		return query;
	}
	public void setQuery(Object query) {
		this.query = query;
	}
	public FilterProps[] getFilter() {
		return filter;
	}
	public void setFilter(FilterProps[] filter) {
		this.filter = filter;
	}
	public void setFilter(FilterProps filter) {
		List<FilterProps> newFiler = Arrays.asList(filter);
		this.filter = (FilterProps[]) newFiler.stream().map(e->e).toArray();
	}
	public String[] getSearchFileds() {
		if(this.getSearchFiled()==null) {
			this.searchFiled = "";
		}
		return this.getSearchFiled().isEmpty() ? null  : this.getSearchFiled().split(",");
	}
	
	
}
