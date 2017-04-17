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
import viajes.model.VIA;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		String viajeID = request.getParameter("via");
		String auth = request.getParameter("auth");
		
		if (viajeID == null){
			String rembID = request.getParameter("remb");
			
			VIADAO dao2 = VIADAOImpl.getInstancia();
			REMBDAO dao3 = REMBDAOImpl.getInstancia();
			String usuario = (String) request.getSession().getAttribute("usuario");
			REMB remb = dao3.getREMBID(rembID);			
			dao3.deleteRemb(remb);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("viajesemp", dao2.getVIAEmpleado(usuario));
			request.getSession().setAttribute("rembemp", dao3.getREMBEmpleado(usuario));
			request.getSession().setAttribute("viajesup", dao2.getVIASuperior(usuario));
			request.getSession().setAttribute("rembsup", dao3.getREMBSuperior(usuario));
			
			if (auth.equals("emp")){
				RequestDispatcher view4 = request.getRequestDispatcher("EmpView.jsp");
				try {
					view4.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
			
			else{
				
				RequestDispatcher view4 = request.getRequestDispatcher("SupEmpView.jsp");
				try {
					view4.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		else {
			
			VIADAO dao2 = VIADAOImpl.getInstancia();
			REMBDAO dao3 = REMBDAOImpl.getInstancia();
			String usuario = (String) request.getSession().getAttribute("usuario");
			VIA via = dao2.getVIAID(viajeID);
			dao2.deleteVIA(via);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("viajesemp", dao2.getVIAEmpleado(usuario));
			request.getSession().setAttribute("rembemp", dao3.getREMBEmpleado(usuario));
			request.getSession().setAttribute("viajesup", dao2.getVIASuperior(usuario));
			request.getSession().setAttribute("rembsup", dao3.getREMBSuperior(usuario));
			
			if (auth.equals("emp")){
				RequestDispatcher view4 = request.getRequestDispatcher("EmpView.jsp");
				try {
					view4.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
			
			else{
				
				RequestDispatcher view4 = request.getRequestDispatcher("SupEmpView.jsp");
				try {
					view4.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
