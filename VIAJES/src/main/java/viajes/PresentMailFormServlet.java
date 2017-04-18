package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentMailFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public PresentMailFormServlet(){	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		request.getSession().setAttribute("proy", request.getParameter("proy"));
		
		RequestDispatcher view4 = request.getRequestDispatcher("MailView.jsp");
		try {
			view4.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
	}

}
