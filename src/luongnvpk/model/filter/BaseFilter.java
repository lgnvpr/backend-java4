package luongnvpk.model.filter;

public class BaseFilter {
	String  search = "";
	String searchFiled = "";
	Object query = new Object();
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
	
	public String[] getSearchFileds() {
		if(this.getSearchFiled()==null) {
			this.searchFiled = "";
		}
		return this.getSearchFiled().isEmpty() ? null  : this.getSearchFiled().split(",");
	}
	
	
}
