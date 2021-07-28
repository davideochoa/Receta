package receta.BitacoraExistenciaExterna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    static final List<RegistroExistenciaSRV> bitacora = new ArrayList<RegistroExistenciaSRV>();
    
    @GET
    @Path("listarExistencias")
    @Produces(MediaType.APPLICATION_JSON)    
    public List<RegistroExistenciaSRV> listarExistencias(){        
        Statement sentencia = Conexion.getSentencia();        
        bitacora.clear();
        try {
            //sentencia.executeUpdate("INSERT INTO bitacora (idSurtidor,clave,cantidad) VALUES (1,'101',10)");            
            ResultSet rs = sentencia.executeQuery("SELECT idSurtidor,clave,cantidad,timestamp " +
                                                    "FROM bitacora " +
                                                    "ORDER BY timestamp, idSurtidor,clave,cantidad");            
            while(rs.next() == true){
                bitacora.add(new RegistroExistenciaSRV(rs.getInt("idSurtidor"),
                                                    rs.getString("clave"),
                                                    rs.getInt("cantidad"),
                                                    new Date(rs.getTimestamp("timestamp").getTime())));
            }                        
            Conexion.close();
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());                
        }                           
        return bitacora;
    }
    
    @GET
    @Path("buscarExistencia/{IdSurtidor}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public List<RegistroExistenciaSRV> buscarExistencia(@PathParam("IdSurtidor") int IdSurtidor,
                                                @PathParam("clave") String clave) {
        
        if(clave.equals("X"))
            clave = "";
        
        try {
            Statement sentencia = Conexion.getSentencia();            
            bitacora.clear();
            
            String str_sentencia = "SELECT idSurtidor,clave,cantidad,timestamp " +
                                    "FROM bitacora ";
            
            if(IdSurtidor > 0 && clave.length() == 0){
                str_sentencia += "WHERE idSurtidor = '"+IdSurtidor+"' ORDER BY timestamp,clave,cantidad";
                
            }
            
            if(IdSurtidor == 0 && clave.length() > 0){
                str_sentencia += "WHERE clave = '"+clave+"' ORDER BY timestamp,idSurtidor,cantidad";
            }
            
            if(IdSurtidor > 0 && clave.length() > 0){
                str_sentencia += "WHERE idSurtidor = '"+IdSurtidor+"' AND clave = '"+clave+"' "+
                        "ORDER BY timestamp, idSurtidor,clave,cantidad";
            }
            /*
            ResultSet rs = sentencia.executeQuery("SELECT idSurtidor,clave,cantidad,timestamp " +
                                                    "FROM bitacora " +
                                                    "ORDER BY timestamp, idSurtidor,clave,cantidad");
            */
            System.out.println("sentencia:"+str_sentencia);
            ResultSet rs = sentencia.executeQuery(str_sentencia);
            while(rs.next() == true){
                bitacora.add(new RegistroExistenciaSRV(rs.getInt("idSurtidor"),
                        rs.getString("clave"),
                        rs.getInt("cantidad"),
                        new Date(rs.getTimestamp("timestamp").getTime())));
            }
            Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExistenciaExterna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bitacora;
    }
    
    /*@GET
    @Path("buscarExistencia/{IdSurtidor}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public RegistroExistenciaSRV buscarExistencia(@PathParam("IdSurtidor") int IdSurtidor,
                                                @PathParam("clave") String clave) {
        
        Statement sentencia = Conexion.getSentencia();        
        RegistroExistenciaSRV registro = new RegistroExistenciaSRV();
        
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
                registro = new RegistroExistenciaSRV();            
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage()); 
        }
        
        Conexion.close();
        
        return registro;
    } */   
    
    @POST
    @Path("agregarExistencia")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RegistroExistenciaSRV> agregarExistencia(RegistroExistenciaSRV re) {
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
