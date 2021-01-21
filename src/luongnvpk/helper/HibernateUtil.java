package luongnvpk.helper;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import Config.Config;
import luongnvpk.model.Account;
import luongnvpk.model.AccountStaff;
import luongnvpk.model.BaseModel;
import luongnvpk.model.Product;

/**
 * Java based configuration
 * 
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
	public static SessionFactory settingDbHelper(Class RepoClass) {
		try {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:" + Config.getCofig().dbUrlConnection());
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "vanluong@123");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			configuration.setProperties(settings);

			configuration.addAnnotatedClass(RepoClass);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println(serviceRegistry);
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
