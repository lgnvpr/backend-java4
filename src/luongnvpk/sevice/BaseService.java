package luongnvpk.sevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import luongnvpk.helper.ErrorRequest;
import luongnvpk.helper.ObjectHelper;
import luongnvpk.helper._C;
import luongnvpk.model.BaseModel;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;
import luongnvpk.repository.BaseRepository;

public class BaseService<T extends BaseModel> extends HttpServlet {
	protected BaseRepository<T> adapter = null;
	protected Gson gson = new Gson();

	protected Paging<T> list(ListFilter filter) {
		System.out.println(ObjectHelper.gson().toJson(filter));
		return this.adapter.list(filter);
	}

	protected List<T> find(FindFilter filter) {
		System.out.println("on find base service");
		return this.adapter.find(filter);
	}

	protected T save(T t) {
		return this.adapter.save(t);
	}

	protected T remove(String id) {
		
		return this.adapter.remove(id);
	}

	protected T getById(String id) {
		return this.adapter.get(id);
	}

	protected T get(String string) {
		System.out.println("on get id");
		return this.adapter.get(string);
	}

	protected ListFilter getParamsListFilter(HttpServletRequest req) {
		Context<ListFilter> ctx = (Context<ListFilter>) req.getAttribute("ctx");
		ListFilter filter = ctx.getParams(ListFilter.class);
		if(filter ==null) {
			filter = new ListFilter();
		}
		filter.autoDefault();		
		return filter;
	}

	protected FindFilter getParamsFindFilter(HttpServletRequest req) {
		Context<FindFilter> ctx = (Context<FindFilter>) req.getAttribute("ctx");
		FindFilter filter = ctx.getParams(FindFilter.class);
		filter.autoDefault();		
		return filter;
	}

	@Override
	public void init() throws ServletException {
		System.out.println("[.....service " + this.getServletName() + " init.....]");
		super.init();
	}

	@Override
	public void destroy() {
		System.out.println("[.....service " + this.getServletName() + "  destroy.....]");
		super.destroy();
	}

	protected String getInfoRequest(HttpServletRequest req) {
		return "[Method GET with method" + req.getMethod() + "and " + "....]" + "Info Params : " + req.getRequestURI();
	}

	protected String getRoute(HttpServletRequest req) {
		return req.getPathInfo() == null ? "/" : req.getPathInfo().toString();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	protected void route(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getInfoRequest(req));
		resp.setContentType("text");
		String route = this.getRoute(req);
		System.out.println("route" + route);
		if (route.equalsIgnoreCase("/")) {
			req.setAttribute("return", this.list(this.getParamsListFilter(req)));
			;
		} else if (route.equals("/find")) {
			req.setAttribute("return", this.find(this.getParamsFindFilter(req)));
		} else if (route.equals("/get")) {
			String id = req.getParameter("id");
			req.setAttribute("return", this.getById(id));
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		T obj = (T) ObjectHelper.getBodyReqest(this.adapter.Repoclass, req);
		req.setAttribute("return", this.remove(obj.getId()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {
		String route = this.getRoute(req);
		if (route.equalsIgnoreCase("/")) {
			Context<T> ctx = (Context<T>) req.getAttribute("ctx");
			
			T obj =  ctx.getParams(this.adapter.Repoclass);
			req.setAttribute("return", this.save(obj));
		}
	}
	
	

}
