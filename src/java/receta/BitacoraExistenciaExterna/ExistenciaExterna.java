package receta.BitacoraExistenciaExterna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    public List<RegistroExistencia> listarExistencias(){        
        Statement sentencia = Conexion.getSentencia();
        
        bitacora.clear();
        try {
            //sentencia.executeUpdate("INSERT INTO bitacora (idSurtidor,clave,cantidad) VALUES (1,'101',10)");
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM bitacora");
            
            while(rs.next() == true){
                bitacora.add(new RegistroExistencia(rs.getInt("idSurtidor"),rs.getString("clave"),rs.getInt("cantidad")));
            }            
            
            Conexion.close();
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());                
        }            
               
        return bitacora;
    }
    
    @POST
    @Path("agregarExistencia")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RegistroExistencia> agregarExistencia(RegistroExistencia re) {
        Statement sentencia = Conexion.getSentencia();
        
        try {
            sentencia.executeUpdate("INSERT INTO bitacora (idSurtidor,clave,cantidad) VALUES ("+
                                        re.getIdSurtidor()+",'"+
                                        re.getClave()+"',"+
                                        re.getCantidad()+")");
            
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());     
        }
        
        Conexion.close();
        
        return listarExistencias();
    }
    
    @POST
    @Path("buscarExistencia/{IdSurtidor}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public RegistroExistencia buscarExistencia(@PathParam("IdSurtidor") int IdSurtidor,
                                                @PathParam("clave") String clave) {
        
        Statement sentencia = Conexion.getSentencia();
        
        RegistroExistencia registro = new RegistroExistencia();
        
        try {
            ResultSet rs = sentencia.executeQuery("SELECT cantidad FROM bitacora WHERE "+
                                                    "IdSurtidor = "+IdSurtidor+" AND "+
                                                    "clave = '"+clave+"'");
            
            if(rs.next() == true){
                registro.setIdSurtidor(IdSurtidor);
                registro.setClave(clave);
                registro.setCantidad(rs.getInt("cantidad"));                
            }
            else
                registro = new RegistroExistencia();
            
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage()); 
        }
        
        Conexion.close();
        
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
