package luongnvpk.sevice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import luongnvpk.model.Account;
import luongnvpk.model.ImageProduct;
import luongnvpk.model.Enum.EService;
import luongnvpk.repository.AccountStaffRepository;
import luongnvpk.repository.BaseRepository;
import luongnvpk.repository.ImageProductRepository;
import luongnvpk.repository.MainRepository;

@WebServlet(name = EService.imageProduct, urlPatterns = { "/"+ EService.imageProduct, "/"+EService.imageProduct+"/*" })
public class ImageProductService extends BaseService<ImageProduct> {
	private ImageProductRepository adapter = MainRepository.imageProductRepo;


	@Override
	public void init() throws ServletException {
		super.init();
		super.adapter = (BaseRepository<ImageProduct>) MainRepository.imageProductRepo;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("");
		switch (this.getRoute(req)) {
			case "/login": {
			}
			default:
				this.route(req, resp);
				break;
		}
	}
}
