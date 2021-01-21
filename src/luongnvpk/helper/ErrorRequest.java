package luongnvpk.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import luongnvpk.model.filter.IError;

public class ErrorRequest {
	String message = "";
	int status;
	static ServletRequest request;
	static ServletResponse response;

	public static ServletRequest getRequest() {
		return request;
	}

	public static void setRequest(ServletRequest request2) {
		ErrorRequest.request = request2;
	}

	public static ServletResponse getResponse() {
		return response;
	}

	public static void setResponse(ServletResponse response2) {
		ErrorRequest.response = response2;
	}

	public static void Error500(String message) throws IOException {
//		request.setAttribute("javax.servlet.error.status_code", 401);
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		IError error = new IError();
		error.setStatus(500);
		error.setMessage(message);
		response.getWriter().print(ObjectHelper.gson().toJson(error));
		response.setContentType("application/json");
		response.getWriter().close();
	}

}
