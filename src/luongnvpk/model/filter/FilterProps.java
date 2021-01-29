package luongnvpk.model.filter;

public class FilterProps {
	String filed;
	Object value;
	
	
	
	public FilterProps() {
		super();
	}
	public FilterProps(String filed, String value) {
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
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
