package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentRembFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PresentRembFormServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		RequestDispatcher view4 = request.getRequestDispatcher("FormRembView.jsp");
		try {
			view4.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
