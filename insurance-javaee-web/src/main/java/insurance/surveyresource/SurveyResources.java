package insurance.surveyresource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.Null;
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

import domain.Survey;
import services.SurveyServiceLocal;
import services.SurveyVoteServiceLocal;

@Path("survey")
@RequestScoped
public class SurveyResources {

	@EJB
	private SurveyServiceLocal surveyServiceLocal;
	@EJB
	private SurveyVoteServiceLocal surveyVoteServiceLocal;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurvey() {
		if (surveyServiceLocal.findAllSurvey() != null)
			return Response.status(Status.OK).entity(surveyServiceLocal.findAllSurvey()).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}

	@Path("{idsurvey}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSurvey(@PathParam(value = "idsurvey") int id) {

		if (surveyServiceLocal.findSurvey(id) != null)
			return Response.status(Status.OK).entity(surveyServiceLocal.findSurvey(id)).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSurvey(Survey survey) {
		surveyServiceLocal.addSurvey(survey);
		return Response.status(Status.CREATED).entity("creation d'une survey avec succée!").build();

	}

	@Path("{idsurvey}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSurvey(@PathParam(value = "idsurvey") int id) {

		if (surveyServiceLocal.findSurvey(id) != null) {
			Survey survey = surveyServiceLocal.findSurvey(id);
			surveyServiceLocal.deleteSurvey(survey);
			return Response.status(Status.CREATED).entity("Supression avec succée!").build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Path("{idsurvey}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSurvey(Survey survey, @PathParam(value = "idsurvey") int id) {

		if (surveyServiceLocal.findSurvey(id) != null) {
			survey.setIdSurvey(id);

			surveyServiceLocal.updateSurvey(survey);
			return Response.status(Status.CREATED).entity("modification avec succée!").build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Path("Result/{idsurvey}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurveyVotes(@PathParam(value = "idsurvey") int idsurvey) {
		if (surveyVoteServiceLocal.findAllSurveyVote() != null)
			return Response.status(Status.OK).entity(surveyVoteServiceLocal.SurveyVoteCountBySurvey(idsurvey)).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}

	
	@Path("/Result/{vote}/{idSurvey}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurveyVotesResult(@PathParam( value = "vote") String vote,@PathParam( value = "idSurvey") int idSurvey) {
		return Response.status(Status.OK).entity(surveyVoteServiceLocal.SurveyVoteCount(vote, idSurvey)).build();

	}

}
