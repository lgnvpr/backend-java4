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

@WebServlet(name = "account", urlPatterns = { "/account", "/account/*" })
public class AccountService extends BaseService<AccountStaff> {
	private AccountStaffRepository adapter = new AccountStaffRepository();

	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		Object username = req.getParameter("username");
//		Object password = req.getParameter("password");
//		String permission[] = req.getParameterValues("permission");
//		String valuePermission = "";
//		if (permission != null) {
//			for (int i = 0; i < _C.value(permission.length, 0); i++) {
//				valuePermission += (permission[i] + ",");
//			}
//		}
//
//		req.setAttribute("username", _C.value(username, "Tên bị rỗng"));
//		req.setAttribute("password", _C.value(password, "Mật khẩu bị rỗng"));
//		req.setAttribute("permission", _C.value(valuePermission, "Ngươi dùng chưa tích vào quyền nào"));
//		req.getRequestDispatcher("/lab1/HomeLab1.jsp").forward(req, resp);
		System.out.println("on login");
		Context<AccountStaff> ctx = (Context<AccountStaff>) req.getAttribute("ctx");
		AccountStaff get =  ctx.getParams(Repoclass);
		return this.adapter.login(get.getUsername(), get.getPassword());
	}
	
	public void  testMigration() {
		migration test = new migration();
		
	}

	@Override
	public void init() throws ServletException {
		super.init();
		super.adapter = (BaseRepository<AccountStaff>) new AccountStaffRepository();
		super.Repoclass = AccountStaff.class;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (this.getRoute(req)) {
		case "/login": {
			req.setAttribute("return", this.login(req, resp));
		}
		default:
			this.route(req, resp);
			break;
		}
	}
}
