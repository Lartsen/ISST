package viajes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import viajes.dao.REMBDAO;
import viajes.dao.REMBDAOImpl;
import viajes.dao.USUDAO;
import viajes.dao.USUDAOImpl;
import viajes.dao.VIADAO;
import viajes.dao.VIADAOImpl;
import viajes.model.REMB;
import viajes.model.USU;
import viajes.model.VIA;


public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadFileServlet() {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		if(request.getSession().getAttribute("is").equals("via")){
			
			VIADAO dao = VIADAOImpl.getInstancia();
			String viaid = (String) request.getSession().getAttribute("via");
			VIA via = dao.getVIAID(viaid);
			
			Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(request);
			List<BlobKey> blobKeys = blobs.get("file");
			if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
				response.sendError(1200);
			}
			via.setDocument(blobKeys.get(0).getKeyString());
			dao.updateVIA(via);
			
		}
		else {
			REMBDAO dao = REMBDAOImpl.getInstancia();
			String rembid = (String) request.getSession().getAttribute("remb");
			REMB remb = dao.getREMBID(rembid);
			
			Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(request);
			List<BlobKey> blobKeys = blobs.get("file");
			if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
				response.sendError(1200);
			}
			remb.setDocument(blobKeys.get(0).getKeyString());
			dao.updateREMB(remb);
		}
		
		String usuario = (String) request.getSession().getAttribute("usuario");
		USUDAO dao1 = USUDAOImpl.getInstancia();
		VIADAO dao2 = VIADAOImpl.getInstancia();
		REMBDAO dao3 = REMBDAOImpl.getInstancia();
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
	}
}
