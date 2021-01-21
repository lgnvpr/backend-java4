package luongnvpk.model.filter;

import java.util.List;

public class Paging <T>{
	List<T> rows;
	int total;
	int totalPages;
	int page;
	int pageSize;
	
	
	
	public Paging() {
		super();
	}
	public Paging(List<T> rows, int total, int totalPages, int page, int pageSize) {
		super();
		this.rows = rows;
		this.total = total;
		this.totalPages = totalPages;
		this.page = page;
		this.pageSize = pageSize;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
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
	
	
}
