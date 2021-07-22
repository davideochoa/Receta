/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receta.BitacoraExistenciaExterna;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RegistroExistencia {
    private int idSurtidor = 0;
    private String clave = "";
    private int cantidad  = 0;
    private String timestamp = "";
    private long milisegundos = 0;
    //timestamp - dd/MM/yyyy HH:mm:ss
    public RegistroExistencia() {}
        
    public RegistroExistencia(int idSurtidor, String clave, int cantidad) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
    }
    
    public RegistroExistencia(int idSurtidor, String clave, int cantidad,Timestamp timestamp) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
        this.setTimestamp(timestamp);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy HH:mm:ss");
        milisegundos = timestamp.getTime();
        
        this.timestamp = format.format(timestamp);
    }
    
    

    public int getIdSurtidor() {
        return idSurtidor;
    }

    public void setIdSurtidor(int idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
