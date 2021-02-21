package luongnvpk.model.filter;

import java.util.Arrays;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class BaseFilter {
	String search = "";
	String[] searchFields;
	Object query = new Object();
	FilterProps[] filter;

	public BaseFilter(String search, String searchFiled[]) {
		super();
		this.search = search;
		this.searchFields = searchFiled;
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

	

	public String[] getSearchFields() {
		return searchFields;
	}

	public void setSearchFields(String[] searchFields) {
		this.searchFields = searchFields;
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
		this.filter = (FilterProps[]) newFiler.stream().map(e -> e).toArray(FilterProps[]::new);
	}

//	public String[] getSearchFileds() {
//		if (this.getSearchFields() == null) {
//			this.searchFields = "";
//		}
//		return this.getSearchFields().isEmpty() ? null : this.getSearchFields().split(",");
//	}

}
