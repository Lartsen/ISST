package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import viajes.dao.REMBDAO;
import viajes.dao.REMBDAOImpl;
import viajes.dao.VIADAO;
import viajes.dao.VIADAOImpl;

import viajes.model.VIA;

public class ManageViaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageViaServlet() {
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		String viajeID = request.getParameter("via");
		String toDo = request.getParameter("toDo");
		
		VIADAO dao2 = VIADAOImpl.getInstancia();
		REMBDAO dao3 = REMBDAOImpl.getInstancia();
		String usuario = (String) request.getSession().getAttribute("usuario");
		VIA via = dao2.getVIAID(viajeID);
		
		switch(toDo){
			case "accept":
				dao2.setEstado(via, 2);
				break;
			case "deny":
				dao2.setEstado(via, 1);
				break;
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("viajesemp", dao2.getVIAEmpleado(usuario));
		request.getSession().setAttribute("rembemp", dao3.getREMBEmpleado(usuario));
		request.getSession().setAttribute("viajesup", dao2.getVIASuperior(usuario));
		request.getSession().setAttribute("rembsup", dao3.getREMBSuperior(usuario));
		RequestDispatcher view4 = request.getRequestDispatcher("SupEmpView.jsp");
		try {
			view4.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
