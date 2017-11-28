package insurance.contractresources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import domain.Contract;
import domain.Reunion;
import services.ContractServiceLocal;
import services.ReunionServiceLocal;

@Path("contract")
@RequestScoped
public class ContractResource {
	@EJB
	private ContractServiceLocal cm;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addContract (Contract c) {
		System.out.println(c);
		if (cm.create(c) != null)
			return Response.status(Status.CREATED).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllContracts() {
		if (cm.findAllContracts() != null)
			return Response.status(Status.FOUND).entity(cm.findAllContracts()).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idcontract}")
	public Response getContractById(@PathParam("idcontract")int id) {
		System.out.println(cm.findContractById(id));
		if (cm.findContractById(id) != null)
			return Response.status(Status.FOUND).entity(cm.findContractById(id)).build();
		return Response.status(Status.NOT_FOUND).entity(new String("Not Found")).build();
	}
}
