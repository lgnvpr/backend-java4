package luongnvpk.helper;

import java.util.Date;

public class _C {
public static Class value(Object v1,Class v2) {
		
		if(v1 != null ) {
			return (Class) v1;
		}
		return v2;
	}
	
	public static String value(Object v1,String v2) {
		
		if(v1 != null && v1.toString() != "") {
			return (String)v1.toString();
		}
		return v2;
	}
	
	public static Date value(Object v1,Date v2) {
		if(v1 != null) {
			Date value = new Date();
			try {
				value = new Date(v1.toString());
			} catch (Exception e) {
				value = v2;
			}
			return value;
		}
		return v2;
	}
	
	public static Float value(Object v1,Float v2) {
		if(v1 != null) {
			Float value = (float) 0;
			try {
				value = Float.parseFloat(v1.toString());
			} catch (Exception e) {
				value = v2;
			}
			return value;
		}
		return v2;
	}
	public static int value(Object v1,int v2) {
		if(v1 != null) {
			int value = 0;
			try {
				value = Integer.parseInt(v1.toString());
			} catch (Exception e) {
				value = v2;
			}
			return value;
		}
		return v2;
	}
	
	
	
	
	
}
