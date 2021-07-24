package receta.BitacoraExistenciaExterna;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RegistroExistenciaSRV {
    private int idSurtidor = 0;
    private String clave = "";
    private int cantidad  = 0;
    private String fecha;
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
        this.setFecha(timestamp);
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy HH:mm:ss");
        
        this.fecha = format.format(timestamp);
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
