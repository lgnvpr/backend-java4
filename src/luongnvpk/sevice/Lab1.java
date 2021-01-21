package luongnvpk.sevice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

import luongnvpk.model.BaseModel;


@WebServlet(
		name = "calc",
		urlPatterns = {"/calc"}
)
public class Lab1 extends BaseService<BaseModel>{
	public float sum(float numeberOne, float numberTwo) {
		return numeberOne + numberTwo;
	}
	
	public float minus(float numeberOne, float numberTwo) {
		return numeberOne - numberTwo;
	}
	
	public float division(float numberOne ,float numberTwo) {
		return numberOne/numberTwo;
	}
	
	public float multiplication(float numberOne ,float numberTwo) {
		return numberOne*numberTwo;
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("calc init ");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getType = req.getParameter("type");
		float numberOne =Float.valueOf(req.getParameter("numberOne"));
		float numberTwo =Float.valueOf(req.getParameter("numberTwo"));
		System.out.println("on calc");
		float getResult = 0;
		switch (getType) {
		case "sum": {
			getResult =  this.sum(numberOne, numberTwo);
			break;
		}
		case "minus": {
			getResult = this.minus(numberOne, numberTwo);
			break;
		}
		case "division": {
			getResult =  this.division(numberOne, numberTwo);
			break;
		}
		case "multiplication": {
			getResult =  this.multiplication(numberOne, numberTwo);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + getType);
		}
		PrintWriter print = resp.getWriter();
		req.setAttribute("result", getResult);
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("lab1/HomeLab1.jsp").forward(req, resp);
//		print.print(getResult);		
		
	}
	
	
}
