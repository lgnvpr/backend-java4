package luongnvpk.sevice;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import luongnvpk.helper.HibernateUtil;
import luongnvpk.model.Account;
import luongnvpk.model.Product;
import luongnvpk.model.Enum.EService;
import luongnvpk.repository.AccountStaffRepository;
import luongnvpk.repository.BaseRepository;
import luongnvpk.repository.MainRepository;
import luongnvpk.repository.ProductRepository;

@WebServlet(name = EService.product, urlPatterns = { "/"+ EService.product, "/"+EService.product+"/*" })
public class ProductServlet extends BaseService<Product>{
	@Override
	public void init() throws ServletException {
		System.out.println("product service is init");
		super.init();
		super.adapter = (BaseRepository<Product>) MainRepository.productRepo;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (this.getRoute(req)) {
		case "/login": {
			
		}
		default:
			this.route(req, resp);
			break;
		}
	}
}