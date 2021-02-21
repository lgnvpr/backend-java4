package luongnvpk.model.filter;

import luongnvpk.helper._C;

public class ListFilter extends BaseFilter {
	int page = 1;
	int pageSize = 10;
	String sort = "";

	public ListFilter(int page, int pageSize, String sort, String search, String searchFiled[]) {
		super(search, searchFiled);
		this.page = page;
		this.pageSize = pageSize;
		this.sort = sort;
	}

	public ListFilter() {
		super();
		this.page = 1;
		this.pageSize = 10;
		this.sort = "";
	}

	public void autoDefault() {
		this.setPage(_C.value(this.getPage(), 1000));
		this.setPageSize(_C.value(this.getPageSize(), 0));
		this.setSearch(_C.value(this.getSearch(), ""));
		this.setSearchFields(this.getSearchFields());
		this.setSort(_C.value(this.getSort(), ""));
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
