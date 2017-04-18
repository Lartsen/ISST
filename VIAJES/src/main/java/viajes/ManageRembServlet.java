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
import viajes.model.REMB;

public class ManageRembServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageRembServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		String rembID = request.getParameter("remb");
		String toDo = request.getParameter("toDo");
		String auth = request.getParameter("auth");
		
		VIADAO dao2 = VIADAOImpl.getInstancia();
		REMBDAO dao3 = REMBDAOImpl.getInstancia();
		String usuario = (String) request.getSession().getAttribute("usuario");
		REMB remb = dao3.getREMBID(rembID);
				
		
		if(auth.equals("sup")){
			switch(toDo){
			case "accept":
				if(remb.getEstado() != 3){
					dao3.setEstado(remb, 2);
				}
				break;
			case "deny":
				if(remb.getEstado() != 3){
					dao3.setEstado(remb, 1);
				}
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
		else  {
			
			switch(toDo){
			case "accept":
				if(remb.getEstado() >= 2){
					dao3.setEstado(remb, 3);
				}
				break;
			case "deny":
				if(remb.getEstado() >= 2){
					dao3.setEstado(remb, 1);
				}
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("rembemp", dao3.getAllREMB());
			
			RequestDispatcher view4 = request.getRequestDispatcher("OcgView.jsp");
			try {
				view4.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
}
