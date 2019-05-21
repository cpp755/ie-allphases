package ir.asta.training.contacts.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.UserEntity;

@Path("/contact")
public interface ContactService {

	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML})
	public Response signUp(UserEntity userEntity);

	@POST
	@Path("/signin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
	public Response signIn(String s) throws JsonProcessingException;

	@POST
	@Path("/choosesatisfaction")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
	public Response chooseSatisfaction(String s) throws JsonProcessingException;

	@POST
	@Path("/refreshcase")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
	public Response refreshcase(String s) throws JsonProcessingException;

	@POST
	@Path("/changepass")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_JSON})
	public Response changePass(String s) throws JsonProcessingException;
	
}
