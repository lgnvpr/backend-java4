package luongnvpk.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import luongnvpk.model.filter.IError;

public class ErrorRequest {
	static String message = "";
	

	static int status;
	static ServletRequest request;
	static ServletResponse response;
	
	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		ErrorRequest.message = message;
	}

	public static int getStatus() {
		return status;
	}

	public static void setStatus(int status) {
		ErrorRequest.status = status;
	}

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
	
	public static void BadInput(String mesage) throws IOException {
		ErrorRequest.ReturnError(mesage, 430);
	}
	
	public static void Authen() throws IOException {
		ErrorRequest.ReturnError("Authencation", 401);
	}

	public static void Error500(String message) throws IOException {
		ErrorRequest.ReturnError(message, 500);
	}
	
	public static void ReturnError(String message, int status ) throws IOException {
		IError error = new IError();
		error.setMessage(message);
		ErrorRequest.setMessage(message);
		ErrorRequest.setStatus(status);
		response.setCharacterEncoding("UTF-8");
		((HttpServletResponse) response).setStatus(status);
		response.getWriter().write(ObjectHelper.gson().toJson(error));
		((HttpServletResponse) response).setHeader("Content-Type", "application/json");
	}

}
