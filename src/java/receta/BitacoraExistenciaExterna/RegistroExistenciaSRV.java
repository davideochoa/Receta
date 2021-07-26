package receta.BitacoraExistenciaExterna;

import java.util.Date;

public class RegistroExistenciaSRV {
    private int idSurtidor = 0;
    private String clave = "";
    private int cantidad  = 0;
    private Date timestamp;
    public RegistroExistenciaSRV() {}
    public RegistroExistenciaSRV(int idSurtidor, String clave, int cantidad) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
    }
    public RegistroExistenciaSRV(int idSurtidor, String clave, int cantidad,Date timestamp) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
        this.setFecha(timestamp);
    }
    
    public Date getFecha() {
        return timestamp;
    }
    public void setFecha(Date timestamp) {
        //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy HH:mm:ss");
        
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
