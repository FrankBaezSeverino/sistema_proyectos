package com.dafi.proyectos.persona.servicio;

import com.dafi.proyectos.persona.modelo.Persona;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Path("/personas")
@Stateless
public class PersonaServicioRS {
   
	@Inject
    private PersonaServicio personaServicio;
	

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/listar")
    public List<Persona> listarPersonas() throws Exception {
    		return personaServicio.listarPersonas();
    }
	
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/encontrarPorId/{id}")
    public Persona encontrarPersonaPorId(@PathParam("id") int id) throws Exception {
    		return personaServicio.encontrarPersonaPorId(id);
    }
    

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/registar")
    public Response agregarPersona(Persona persona) {
        try {
        	personaServicio.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/modificar/{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaServicio.encontrarPersonaPorId(personaModificada);
            if (persona != null) {
            	personaServicio.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("eliminar/{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
        	personaServicio.eliminarPersona(personaServicio.encontrarPersonaPorId(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
    
}
