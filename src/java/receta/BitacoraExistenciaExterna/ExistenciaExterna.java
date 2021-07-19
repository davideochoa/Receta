package receta.BitacoraExistenciaExterna;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        if(bitacora.size() == 0){
            bitacora.add(new RegistroExistencia(1,"106",30));

            try {
                DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/receta");
                
                Connection con = ds.getConnection();
                Statement sentencia = con.createStatement();
                ResultSet rs = sentencia.executeQuery("SELECT * FROM bitacora");
                if(rs.next() == true){
                    System.out.println("BD OK");   
                    System.out.println(rs.getInt("idSurtidor"));
                    System.out.println(rs.getString("clave"));
                    System.out.println(rs.getInt("cantidad"));
                }
                else
                    System.out.println("BD BAD");   
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());                
            } catch (NamingException ex) {
                Logger.getLogger(ExistenciaExterna.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
        
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
    
    @POST
    @Path("buscarExistencia/{IdSurtidor}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public RegistroExistencia buscarExistencia(@PathParam("IdSurtidor") int IdSurtidor,
                                                @PathParam("clave") String clave) {
        RegistroExistencia registro = new RegistroExistencia();
        
        for(RegistroExistencia re:bitacora){
            if(re.getIdSurtidor() == IdSurtidor &&
                re.getClave().equals(clave)){
                
                registro.setClave(re.getClave());
                registro.setCantidad(re.getCantidad());
                registro.setIdSurtidor(re.getIdSurtidor());
            }
        }        
        return registro;
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
