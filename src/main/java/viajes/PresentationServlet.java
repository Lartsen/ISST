package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import viajes.dao.USUDAO;
import viajes.dao.USUDAOImpl;
import viajes.model.REMB;
import viajes.model.USU;
import viajes.model.VIA;

public class PresentationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public PresentationServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(USU.class);
		ObjectifyService.register(VIA.class);
		ObjectifyService.register(REMB.class);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		USUDAO dao1 = USUDAOImpl.getInstancia();
		
		dao1.createUSUDAO("empleado1", "empleado1", 0, "superior1");
		dao1.createUSUDAO("superior1", "superior1", 2, "superior2");
		dao1.createUSUDAO("superior2", "superior2", 2, "nadie");
		dao1.createUSUDAO("ocg", "ocg", 3, "nadie");
		
		RequestDispatcher view4 = request.getRequestDispatcher("LoginView.jsp");
		try {
			view4.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}

