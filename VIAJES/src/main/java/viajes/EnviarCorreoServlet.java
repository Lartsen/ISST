package viajes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import viajes.dao.PRODAO;
import viajes.dao.PRODAOImpl;
import viajes.dao.USUDAO;
import viajes.dao.USUDAOImpl;

public class EnviarCorreoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EnviarCorreoServlet(){
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		USUDAO dao = USUDAOImpl.getInstancia();
		PRODAO dao2 = PRODAOImpl.getInstancia();
		String usuario = (String) request.getSession().getAttribute("usuario");
		String texto = request.getParameter("texto");
		String asunto = request.getParameter("asunto");
		String correo = null;

		if(usuario != null){
			
			String proyecto = (String) request.getSession().getAttribute("proy");
			String superior = dao2.getPro(proyecto).getSuperior();
			correo = dao.getUSU(superior).getCorreo();
			int rol = dao.getUSU(usuario).getRol();
			
			MimeMessage msg = new MimeMessage(Session.getDefaultInstance(new Properties()));
			try {
				msg.setFrom(new InternetAddress("mai@isst-gestionviajes.appspotmail.com", "Sistema de gestión de Viajes"));
				msg.addRecipient(MimeMessage.RecipientType.TO,
				        new InternetAddress(correo, "Superior "));
				msg.setSubject(asunto);
				msg.setText(texto);
				Transport.send(msg);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
		switch (rol){
			case 0:
				RequestDispatcher view = request.getRequestDispatcher("EmpView.jsp");
				try {
					view.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
				break;
			case 1:
				RequestDispatcher view1 = request.getRequestDispatcher("SupView.jsp");
				try {
					view1.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				RequestDispatcher view2 = request.getRequestDispatcher("SupEmpView.jsp");
				try {
					view2.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
				break;
			case 3:
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
		}
		
	}
	
}
