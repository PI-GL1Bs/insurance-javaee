package insurance.userresource;



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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import domain.User;
import services.UserServiceLocal;



@Path("user")
@RequestScoped
public class UserResource {

	@EJB
	UserServiceLocal UserService ;
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser (@QueryParam(value="login") String login ,@QueryParam(value="password") String password) 
	{
        if (UserService.authentification(login,password)!=null)
	    return Response.status(Status.ACCEPTED).entity(UserService.authentification(login,password)).build();
        else 
		return Response.status(Status.ACCEPTED).entity(new User()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		if (UserService.findAllUsers() != null)
			return Response.status(Status.FOUND).entity(UserService.findAllUsers()).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cin}")
	public Response deleteUser(@PathParam("cin") int cin) {
		User u = UserService.findUserById(cin);
		UserService.deleteUser(u);
		return Response.status(Status.OK).entity("user removed").build();
	}
	
	@GET
	@Path("{cin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response chercherUser(@PathParam("cin") int cin) 
	{
		if(UserService.findUserById(cin)!=null)
			return Response.status(Status.OK).entity(UserService.findUserById(cin)).build() ;
			else
				return Response.status(Status.NOT_FOUND).build();
	}
	  @POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response ajoutUser(User u)
		{
		 UserService.createUser(u);
		 return Response.status(Status.CREATED).entity("user added").build();
			
		}
	  @PUT
	  @Path("{cin}")
	  @Consumes(MediaType.APPLICATION_JSON)

	  public Response UpdateUser(@PathParam("cin") int cin, User u) {
	  	u.setId(cin);
	  	if (UserService.updateUser(u)){

	  		return Response.status(Status.OK).build();
	  	}

	  	return Response.status(Status.NOT_FOUND).build();
	  }
	
}
