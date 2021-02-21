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
import luongnvpk.model.CartProduct;
import luongnvpk.model.Product;
import luongnvpk.model.Enum.EService;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.repository.AccountStaffRepository;
import luongnvpk.repository.BaseRepository;
import luongnvpk.repository.MainRepository;
import luongnvpk.repository.ProductRepository;

@WebServlet(name = EService.cartProduct, urlPatterns = { "/"+ EService.cartProduct, "/"+EService.cartProduct+"/*" })
public class ProductCartServlet extends BaseService<CartProduct>{
	@Override
	public void init() throws ServletException {
		System.out.println("product service is init");
		super.init();
		super.adapter = (BaseRepository<CartProduct>) MainRepository.cartProductRepo;
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		switch (this.getRoute(req)) {
		case "/addToCart": {
			Context<CartProduct> ctx = (Context<CartProduct>) req.getAttribute("ctx");
			CartProduct item = ctx.getParams(this.adapter.Repoclass);
			req.setAttribute("return", MainRepository.cartProductRepo.addToCart(item));
		}
		default:
			this.routePost(req, resp);
			break;
		}
	}
}