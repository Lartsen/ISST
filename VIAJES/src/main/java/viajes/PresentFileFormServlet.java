package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentFileFormServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public PresentFileFormServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		request.getSession().setAttribute("proy", request.getParameter("proy"));
		request.getSession().setAttribute("auth", request.getParameter("auth"));
		request.getSession().setAttribute("is", request.getParameter("is"));
		
		if(request.getParameter("is").equals("via")){
			request.getSession().setAttribute("via", request.getParameter("via"));
		}
		
		else {
			request.getSession().setAttribute("remb", request.getParameter("remb"));
		}
		
		RequestDispatcher view = request.getRequestDispatcher("FormUploadView.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	

}
