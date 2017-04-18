package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import viajes.dao.PRODAO;
import viajes.dao.PRODAOImpl;
import viajes.dao.USUDAO;
import viajes.dao.USUDAOImpl;
import viajes.model.PRO;
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
		ObjectifyService.register(PRO.class);
		
		USUDAO dao1 = USUDAOImpl.getInstancia();
		PRODAO dao2 = PRODAOImpl.getInstancia();
		
		//VIADAO dao3 = VIADAOImpl.getInstancia();
		//REMBDAO dao4 = REMBDAOImpl.getInstancia();
		
		dao1.createUSU("empleado1", "empleado1", 0, "fbenayounacdc@gmail.com");
		dao1.createUSU("superior1", "superior1", 2, "ferbenayas94@gmail.com");
		dao1.createUSU("superior2", "superior2", 2, "ferbenayas94@hotmail.com");
		dao1.createUSU("ocg", "ocg", 3, "f.benayas@alumnos.upm.es");
		
		dao2.createPRO("IoT", "superior1");
		dao2.createPRO("SDN", "superior1");
		dao2.createPRO("IA", "superior2");
		dao2.createPRO("Radar", "superior1");
		dao2.createPRO("MIMO", "superior2");
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		RequestDispatcher view4 = request.getRequestDispatcher("LoginView.jsp");
		try {
			view4.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}

