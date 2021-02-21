package luongnvpk.model.filter;

import luongnvpk.helper.ObjectHelper;

public class FilterProps {
	String filed;
	String[] value;
	
	
	
	public FilterProps() {
		super();
	}
	public FilterProps(String filed, String value[]) {
		super();
		this.filed = filed;
		this.value = value;
	}
	public String getFiled() {
		return filed;
	}
	public void setFiled(String filed) {
		this.filed = filed;
	}
	public String[] getValue() {
		return value;
	}
	public void setValue(String[] value) {
		this.value = value;
	}
	
	
}
