package luongnvpk.middlewares;

import java.io.Console;
import java.io.IOException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import luongnvpk.helper.ErrorRequest;
import luongnvpk.helper.ObjectHelper;
import luongnvpk.helper._C;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.sevice.Context;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.google.gson.Gson;


@WebFilter(
	urlPatterns = "/*"
)
public class Filter implements javax.servlet.Filter{
	private Gson gson = new Gson();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String paramsJson = ObjectHelper.getParamsJson(request);
		ErrorRequest.setRequest(request);
		ErrorRequest.setResponse(response);
		Context<FindFilter> ctx = new Context<FindFilter>();
		ctx.setParams(paramsJson);
		request.setAttribute("ctx", ctx);
		chain.doFilter(request, response);		
//		 ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
//	        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
//	 
		response.getWriter().print(gson.toJson(request.getAttribute("return")));
		response.setContentType("application/json");
		response.getWriter().close();
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}
	
}