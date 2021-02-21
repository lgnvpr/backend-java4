package luongnvpk.model.filter;

import luongnvpk.helper._C;

public class FindFilter extends BaseFilter{
	int limit = 0;
	int offset = 0;
	String sort = "";
	
	
	
	public FindFilter() {
		super();
		this.autoDefault();
	}
	
	
	public FindFilter(String search, String searchFiled[], int limit, int offset) {
		super(search, searchFiled);
		this.limit = limit;
		this.offset = offset;
	}
	
	public void autoDefault() {
		this.setLimit(_C.value(this.getLimit(), 1000));
		this.setOffset( _C.value(this.getOffset(), 0));
		this.setSearch( _C.value(this.getSearch(), ""));
		this.setSearchFields(this.getSearchFields());
		this.setSort(_C.value(this.getSort(), ""));
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String[] getSorts() {
		if(this.getSort()==null) {
			this.sort = "";
		}
		return this.getSort().isEmpty() ? null  : this.getSort().split(",");
	}
}
