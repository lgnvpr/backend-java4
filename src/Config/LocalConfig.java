package Config;

public class LocalConfig implements Iconfig{

	@Override
	public String jwt() {
		return "luongflynotes";
	}

	@Override
	public String dbUrlConnection() {
		return "mysql://localhost:3306/shopping_luongnvpk01506";
	}

	@Override
	public String getwayApi() {
		return "http://localhost:8080";
	}
	
}
