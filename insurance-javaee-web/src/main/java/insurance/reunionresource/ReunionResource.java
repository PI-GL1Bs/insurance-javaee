package insurance.reunionresource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

import domain.Reunion;
import services.ReunionServiceLocal;

@Path("reunion")
@RequestScoped
public class ReunionResource {
	@EJB
	ReunionServiceLocal reunionServiceLocal;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addReunion (Reunion reunion) {
		System.out.println("===========Reunion==========");
		System.out.println(reunion);
		if (reunionServiceLocal.addReunion(reunion) != null)
			return Response.status(Status.CREATED).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReunions() {
		System.out.println("d5aaaaal elkol");
		if (reunionServiceLocal.findAllReunions() != null)
			return Response.status(Status.OK).entity(reunionServiceLocal.findAllReunions()).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idreunion}")
	public Response getReunionById(@PathParam("idreunion")int id) {
		if (reunionServiceLocal.findReunionById(id) != null)
			return Response.status(Status.OK).entity(reunionServiceLocal.findReunionById(id)).build();
		return Response.status(Status.NOT_FOUND).entity(new String("Not Found")).build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateReunion(Reunion reunion){
		if (reunionServiceLocal.saveReunion(reunion)!= null)
			return Response.status(Status.ACCEPTED).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	@DELETE
	public Response deleteReunion(Reunion reunion){
		if (reunionServiceLocal.removeMeeting(reunion))
			return Response.status(Status.ACCEPTED).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
}
