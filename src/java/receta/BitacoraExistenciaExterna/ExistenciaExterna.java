/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receta.BitacoraExistenciaExterna;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("ExistenciaExterna")
public class ExistenciaExterna {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ExistenciaExterna
     */
    public ExistenciaExterna() {
    }

    /**
     * Retrieves representation of an instance of receta.BitacoraExistenciaExterna.ExistenciaExterna
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<h1> PRUEBA GET </h1>";
    }

    /**
     * PUT method for updating or creating an instance of ExistenciaExterna
     * @param content representation for the resource
     
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }*/
}
