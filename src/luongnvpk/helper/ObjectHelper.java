package luongnvpk.helper;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import luongnvpk.model.AccountStaff;

public class ObjectHelper {
	private static Gson gson = new Gson();
	public static Object getBodyReqest(Class classConvert, HttpServletRequest req) {
		 return gson.fromJson(ObjectHelper.getBodyRequestWithReq(req), classConvert);
	}
	
	private static String getBodyRequestWithReq(ServletRequest req) {
		 StringBuffer jb = new StringBuffer();
		 String line = null;
		 try {
		  BufferedReader reader = req.getReader();
		  while ((line = reader.readLine()) != null)
		   jb.append(line);
		 } catch (Exception e) { /*report an error*/ }
		 return jb.toString();
	}
	
	private static String getParamsRequestWithReq(ServletRequest request) {
		Object[] key=  request.getParameterMap().keySet().toArray();
		Collection<String[]> getValue= request.getParameterMap().values();
		List<String[]> values = new ArrayList(getValue);
		String json = "";
		if(key !=null) {
			for(int i =0 ; i< key.length ; i++) {
				if(i==0) {
					json += "{\n";
				}
				String[] value = values.get(i);
				if(value!=null) {
					for(int j = 0 ; j<  value.length;j++) {
						json += ("\"" +  key[i]+ "\"" +
								":" + 
								"\"" +  _C.value(value[j], "") +"\"");
						if(i != key.length-1) {
							json+= ",\n";
						}
						else {
							json+= "\n}";
						}
					}
				}
			}
		}
		return json;
	}
	
	public static String getParamsJson(ServletRequest req) {
		String body = ObjectHelper.getBodyRequestWithReq(req);
		String params = ObjectHelper.getParamsRequestWithReq(req);
		if(body !=null && body.trim() != ""&& params!= null && params.trim() != "") {
			String mergeParams =  params.substring(0,params.length()-1) +",\n" +body.substring(1, body.length());
			return mergeParams;
		}
		return _C.value(body, params);
	}
	
	public static Gson gson() {
		return gson;
	}
}
