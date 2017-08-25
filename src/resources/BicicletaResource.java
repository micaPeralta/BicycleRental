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
import entities.Bicicleta;
import daos.FactoryDAO;

@Path("/bicicletas")
public class BicicletaResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	GenericDAO<Bicicleta> bicicletaDAO;


	public BicicletaResource(){
		bicicletaDAO = FactoryDAO.getBicicletaDAO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicicleta> getBicicletas(){
		System.out.println(bicicletaDAO.list("Bicicleta").size());
		return bicicletaDAO.list("Bicicleta");
	}


	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Bicicleta getBicicleta(@PathParam("id") String id){
		Long idl = new Long(id);
		Bicicleta bicicleta = bicicletaDAO.find(idl);
		if(bicicleta ==null)
            throw new NotFoundException("No such user.");
		return bicicleta;
	}


	@Path("{id}")
	@DELETE
	public void deleteBicicleta(@PathParam("id") String id) {
		Long idl = new Long(id);
		Bicicleta u= bicicletaDAO.find(idl);
		if (u == null){
			throw new NotFoundException("No such user.");
		}
	    bicicletaDAO.remove(idl);

	}


	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBicicleta(@PathParam("id") String id,Bicicleta bicicleta_mod){

		Long idl = new Long(id);
		Bicicleta bicicleta = bicicletaDAO.find(idl);
		if(bicicleta ==null)
            throw new NotFoundException("No such user.");
		try {
			bicicletaDAO.update(bicicleta_mod);
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		return Response.status(HttpServletResponse.SC_OK).entity(bicicleta_mod).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response  createBicicleta(Bicicleta nuevoBicicleta){
		try {
			bicicletaDAO.persist(nuevoBicicleta);
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(nuevoBicicleta.getId()));
		return Response.created(builder.build()).build();
	}

}
