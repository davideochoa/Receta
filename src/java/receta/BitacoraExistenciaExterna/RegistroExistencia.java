/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receta.BitacoraExistenciaExterna;

/**
 *
 * @author Usuario
 */
public class RegistroExistencia {
    private int idSurtidor = 0;
    private String clave = "";
    private int cantidad  = 0;

    public RegistroExistencia() {
     
    }
        
    public RegistroExistencia(int idSurtidor, String clave, int cantidad) {
        this.setIdSurtidor(idSurtidor);
        this.setClave(clave);
        this.setCantidad(cantidad);
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
