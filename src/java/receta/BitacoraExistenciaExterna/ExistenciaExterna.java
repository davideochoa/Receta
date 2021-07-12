package receta.BitacoraExistenciaExterna;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("ExistenciaExterna")
public class ExistenciaExterna {

    @Context
    private UriInfo context;

    public ExistenciaExterna(){}
    
    static final List<RegistroExistencia> bitacora = new ArrayList<RegistroExistencia>(); 
    
    @GET
    @Path("listarExistencias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RegistroExistencia> listarExistencias() {
        //bitacora.add(new RegistroExistencia(1,"104",10));
        //bitacora.add(new RegistroExistencia(1,"105",20));
        //bitacora.add(new RegistroExistencia(1,"106",30));
        
        if(bitacora.size() == 0)
            bitacora.add(new RegistroExistencia(1,"106",30));
        
        return bitacora;
        //return "<h1> PRUEBA GET </h1>";
    }
    
    @POST
    @Path("agregarExistencia")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RegistroExistencia> agregarExistencia(RegistroExistencia re) {
        bitacora.add(re); 
        return bitacora;
    }
/*
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
    */
}
