package viajes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import viajes.dao.REMBDAO;
import viajes.dao.REMBDAOImpl;
import viajes.dao.USUDAO;
import viajes.dao.USUDAOImpl;
import viajes.dao.VIADAO;
import viajes.dao.VIADAOImpl;
import viajes.model.USU;

public class RembFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RembFormServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		VIADAO dao2 = VIADAOImpl.getInstancia();
		REMBDAO dao3 = REMBDAOImpl.getInstancia();
		String usuario = (String) request.getSession().getAttribute("usuario");
		
		
		dao3.createREMB(request.getParameter("destino"), usuario, request.getParameter("proyecto"), Integer.parseInt(request.getParameter("cantidad")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		USUDAO dao1 = USUDAOImpl.getInstancia();
		USU usu = dao1.getUSU(usuario);
		int rol = usu.getRol();
		
		switch (rol){
		case 0:
			request.getSession().setAttribute("viajesemp", dao2.getVIAEmpleado(usuario));
			request.getSession().setAttribute("rembemp", dao3.getREMBEmpleado(usuario));
			RequestDispatcher view = request.getRequestDispatcher("EmpView.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			request.getSession().setAttribute("viajesup", dao2.getVIASuperior(usuario));
			request.getSession().setAttribute("rembsup", dao3.getREMBSuperior(usuario));
			RequestDispatcher view1 = request.getRequestDispatcher("SupView.jsp");
			try {
				view1.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			
			
			
			request.getSession().setAttribute("viajesemp", dao2.getVIAEmpleado(usuario));
			request.getSession().setAttribute("rembemp", dao3.getREMBEmpleado(usuario));
			request.getSession().setAttribute("viajesup", dao2.getVIASuperior(usuario));
			request.getSession().setAttribute("rembsup", dao3.getREMBSuperior(usuario));
			
			RequestDispatcher view2 = request.getRequestDispatcher("SupEmpView.jsp");
			try {
				view2.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			request.getSession().setAttribute("rembemp", dao3.getAllREMB());
			RequestDispatcher view3 = request.getRequestDispatcher("OcgView.jsp");
			try {
				view3.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		default:
			RequestDispatcher view4 = request.getRequestDispatcher("LoginView.jsp");
			try {
				view4.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		}
		return;
	}
}
