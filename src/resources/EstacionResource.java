package resources;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.tomcat.jni.Error;

import com.sun.research.ws.wadl.Request;

import daos.GenericDAO;
import entities.Estacion;
import daos.FactoryDAO;

@Path("/estaciones")
public class EstacionResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	GenericDAO<Estacion> estacionDAO;


	public EstacionResource(){
		estacionDAO = FactoryDAO.getEstacionDAO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estacion> getEstacionEs(){
		System.out.println(estacionDAO.list("Estacion"));
		return estacionDAO.list("Estacion");
	}


	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Estacion getEstacion(@PathParam("id") String id){
		Long idl = new Long(id);
		Estacion estacion = estacionDAO.find(idl);
		if(estacion ==null)
            throw new NotFoundException("No such user.");
		return estacion;
	}


	@Path("{id}")
	@DELETE
	public void deleteEstacion(@PathParam("id") String id) {
		Long idl = new Long(id);
		Estacion u= estacionDAO.find(idl);
		if (u == null){
			throw new NotFoundException("No such estacion.");
		}
	    estacionDAO.remove(idl);

	}


	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEstacion(@PathParam("id") String id,Estacion estacion_mod){

		Long idl = new Long(id);
		Estacion estacion = estacionDAO.find(idl);
		if(estacion ==null)
            throw new NotFoundException("No such user.");
		try {
			estacionDAO.update(estacion_mod);
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		return Response.status(HttpServletResponse.SC_OK).entity(estacion_mod).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response  createEstacion(Estacion nuevaEstacion){
		try {
			estacionDAO.persist(nuevaEstacion);
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(nuevaEstacion.getId()));
		return Response.created(builder.build()).build();
	}

}
