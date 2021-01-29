package luongnvpk.sevice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import luongnvpk.model.Account;
import luongnvpk.repository.AccountStaffRepository;
import luongnvpk.repository.BaseRepository;
import luongnvpk.repository.MainRepository;

@WebServlet(name = "account", urlPatterns = { "/account", "/account/*" })
public class AccountService extends BaseService<Account> {
	private AccountStaffRepository adapter = MainRepository.accountRepo;

	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("on login");
		Context<Account> ctx = (Context<Account>) req.getAttribute("ctx");
		Account get = ctx.getParams(Repoclass);
		System.out.println(get.getPassword());
		return this.adapter.login(get.getUsername(), get.getPassword());
	}

	@Override
	public void init() throws ServletException {
		super.init();
		super.adapter = (BaseRepository<Account>) MainRepository.accountRepo;
		super.Repoclass = Account.class;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("");
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
