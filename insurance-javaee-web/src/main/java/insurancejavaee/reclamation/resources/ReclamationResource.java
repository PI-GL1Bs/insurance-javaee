package insurancejavaee.reclamation.resources;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import domain.Reclamation;
import domain.Reunion;
import services.ReclamationServiceLocal;

@Path("reclamation")
public class ReclamationResource {

	@EJB
	ReclamationServiceLocal reclamationServiceLocal;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReclamations() {
		List<Reclamation> list = reclamationServiceLocal.findAll();
		if (list != null)
			return Response.status(Status.FOUND).entity(list).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addReclamation (Reclamation reclamation) {
		if (reclamationServiceLocal.create(reclamation))
			return Response.status(Status.CREATED).entity("Created successfully").build();
		return Response.status(Status.BAD_REQUEST).entity("Create fail").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response editReclamation (Reclamation reclamation) {
		
		reclamation.setDateTime(new Date());
		
		if (reclamationServiceLocal.save(reclamation))
			return Response.status(Status.OK).entity("Updated successfully").build();
		return Response.status(Status.BAD_REQUEST).entity("Update fail").build();
	}
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response edeleteReclamation (Reclamation reclamation) {
				
		if (reclamationServiceLocal.delete(reclamation))
			return Response.status(Status.OK).entity("Deleted successfully").build();
		return Response.status(Status.BAD_REQUEST).entity("Delete fail").build();
	}
}
