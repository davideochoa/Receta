package receta.BitacoraExistenciaExterna;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("ExistenciaExterna")
public class ExistenciaExterna {

    @Context
    private UriInfo context;

    public ExistenciaExterna() {    }
    
    final static List<RegistroExistencia> bitacora = new ArrayList<>();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHTML() {
        
        return "<h1> PRUEBA GET </h1>";
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String postHTML() {
        return "<h1> PRUEBA POST </h1>";
    }

    @PUT
    @Produces(MediaType.TEXT_HTML)
    public String putHTML(String content) {
        return "<h1> PRUEBA PUT </h1>";
    }
    
    @DELETE
    @Produces(MediaType.TEXT_HTML)
    public String deleteHTML(String content) {
        return "<h1> PRUEBA DELETE </h1>";
    } 
}
