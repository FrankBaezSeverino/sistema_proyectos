package com.dafi.proyectos.util.negocio.servicio;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import com.dafi.proyectos.util.negocio.datos.EntidadDao;


public abstract class EntidadServicioRS<E> {
   

	protected abstract EntidadDao<E> getEntidadServico();
	

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/listar")
    public List<E> listar() throws Exception {
    		return getEntidadServico().listar();
    }
	
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/encontrar/{id}")
    public E encontrarPorId(@PathParam("id") int id) throws Exception {
    		return getEntidadServico().encontrarPorId(id);
    }
    

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/registrar")
    public Response agregar(E entidad) {
        try {
        	getEntidadServico().registrar(entidad);
            return Response.ok().entity(entidad).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/modificar/{id}")
    public Response modificar(@PathParam("id") int id, E entidadModificada) {
        try {
            E entidad =getEntidadServico().encontrarPorId(entidadModificada);
            if (entidad != null) {
            	getEntidadServico().modificar(entidadModificada);
                return Response.ok().entity(entidadModificada).build();
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
    public Response eliminarPorId(@PathParam("id") int id) {
        try {
        	getEntidadServico().eliminar(getEntidadServico().encontrarPorId(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
    
}
