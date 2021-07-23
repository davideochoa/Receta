/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receta.BitacoraExistenciaExterna;

import jakarta.json.bind.annotation.JsonbDateFormat;
import java.sql.Timestamp;

public class RegistroExistenciaSRV {
    private int idSurtidor = 0;
    private String clave = "";
    private int cantidad  = 0;
    @JsonbDateFormat("dd/MM/yyyy") 
    private Timestamp  timestamp = new Timestamp(1);
    private long milisegundos = 0;
    //timestamp - dd/MM/yyyy HH:mm:ss
    public RegistroExistenciaSRV() {}
        
    public RegistroExistenciaSRV(int idSurtidor, String clave, int cantidad) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
    }
    
    public RegistroExistenciaSRV(int idSurtidor, String clave, int cantidad,Timestamp timestamp) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
        this.setTimestamp(timestamp);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp  timestamp) {
        //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy HH:mm:ss");
        this.milisegundos = timestamp.getTime();        
        this.timestamp = timestamp;
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
