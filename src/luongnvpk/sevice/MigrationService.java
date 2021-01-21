package luongnvpk.sevice;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;

import Migration.migration;
import luongnvpk.helper.ConnectSQL;
import luongnvpk.helper.HibernateUtil;
import luongnvpk.helper.ObjectHelper;
import luongnvpk.helper._C;
import luongnvpk.model.Account;
import luongnvpk.model.AccountStaff;
import luongnvpk.repository.AccountStaffRepository;
import luongnvpk.repository.BaseRepository;

@WebServlet(name = "migration",urlPatterns = { "/migration"} ,loadOnStartup = 1)
public class MigrationService extends BaseService<AccountStaff> {
	
	@Override
	public void init() throws ServletException {
		System.out.println("migraiton is init");
		migration migra = new migration();
		
			try {
				migra.migraion();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		
		super.init();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
