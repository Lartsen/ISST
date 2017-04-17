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

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		String usuario = request.getParameter("usuario");
		String contrase�a = request.getParameter("password");
		
		USUDAO dao1 = USUDAOImpl.getInstancia();
		VIADAO dao2 = VIADAOImpl.getInstancia();
		REMBDAO dao3 = REMBDAOImpl.getInstancia();
		
	
		USU usu = dao1.getUSU(usuario);
		
		if(usu != null && usu.getUsuario().toString().equals(usuario) && usu.getPassword().toString().equals(contrase�a)){
			//CORRECTO, REDIRIGIR A JSP CORRESPONDIENTE SEGUN ROL
			//FALTA A�ADIR VIEW DE ADMIN
			//OJO A LO DE VIEW
			request.getSession().setAttribute("error", null);
			request.getSession().setAttribute("usuario", usuario);
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
		
		else if(usu != null && usu.getUsuario().toString().equals(usuario) && !usu.getPassword().equals(contrase�a)){
			String error = "Contrase�a incorrecta";
			request.getSession().setAttribute("error", error);
			
			RequestDispatcher view = request.getRequestDispatcher("LoginView.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			return;
		}
		
		else{
			String error = "Usuario inexistente";
			request.getSession().setAttribute("error", error);
			
			RequestDispatcher view = request.getRequestDispatcher("LoginView.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			return;
		}
	}
}
