package luongnvpk.sevice;

import luongnvpk.helper.ObjectHelper;

import java.io.Console;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import com.google.common.reflect.TypeToken;


public class Context<T> {
	private String params;
	private  String jwt;
	private Class<T> persistentClass;
	private T type1;
	
	
	public T getParams(Class type) {
		return (T) ObjectHelper.gson().fromJson(this.params, type);
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
	
}
