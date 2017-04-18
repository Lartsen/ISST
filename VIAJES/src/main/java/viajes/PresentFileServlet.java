package viajes;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import viajes.dao.REMBDAO;
import viajes.dao.REMBDAOImpl;
import viajes.dao.VIADAO;
import viajes.dao.VIADAOImpl;
import viajes.model.REMB;
import viajes.model.VIA;



public class PresentFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PresentFileServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		
		if (request.getParameter("is").equals("via")){
			VIADAO dao = VIADAOImpl.getInstancia();
			String viaid = request.getParameter("via");
			VIA via = dao.getVIAID(viaid);
			String memoria = via.getDocument();
			
			BlobKey blobKey = new BlobKey(memoria);
			BlobstoreService blobStoreService = BlobstoreServiceFactory.getBlobstoreService();
	        blobStoreService.serve(blobKey, response);
		}
		
		else{
			REMBDAO dao = REMBDAOImpl.getInstancia();
			String rembid = request.getParameter("remb");
			REMB remb = dao.getREMBID(rembid);
			String memoria = remb.getDocument();
			
			BlobKey blobKey = new BlobKey(memoria);
			BlobstoreService blobStoreService = BlobstoreServiceFactory.getBlobstoreService();
	        blobStoreService.serve(blobKey, response);
		}
	}
}
