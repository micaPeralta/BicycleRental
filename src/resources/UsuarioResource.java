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
import daos.UsuarioDAOImp;
import entities.Usuario;
import daos.FactoryDAO;

@Path("/usuarios")
public class UsuarioResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	GenericDAO<Usuario> usuarioDAO;
	
	
	public UsuarioResource(){
		usuarioDAO = FactoryDAO.getUsuarioDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		System.out.println(usuarioDAO.list("Usuario"));
		return usuarioDAO.list("Usuario");
	}
	
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Usuario getUsuario(@PathParam("id") String id){
		Long idl = new Long(id);
		Usuario usuario = usuarioDAO.find(idl);
		if(usuario ==null)
            throw new NotFoundException("No such user.");
		return usuario;
	}
	
	
	@Path("{id}")
	@DELETE
	public void deleteUsuario(@PathParam("id") String id) {
		Long idl = new Long(id);
		Usuario u= usuarioDAO.find(idl);
		if (u == null){
			throw new NotFoundException("No such user.");
		}
	    usuarioDAO.remove(idl);
	   
	}
	
	
	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@PathParam("id") String id,Usuario usuario_mod){
		
		Long idl = new Long(id);
		Usuario usuario = usuarioDAO.find(idl);
		if(usuario ==null)
            throw new NotFoundException("No such user.");		
		try { 
			usuarioDAO.update(usuario_mod);	
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		return Response.status(HttpServletResponse.SC_OK).entity(usuario_mod).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response  createUsuario(Usuario nuevoUsuario){
		try { 
			usuarioDAO.persist(nuevoUsuario);	
		}
		catch (Exception e ){
			return Response.status(HttpServletResponse.SC_CONFLICT).build();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(nuevoUsuario.getId()));
		return Response.created(builder.build()).build();
	}

}
