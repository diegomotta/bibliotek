/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author diego
 */
public class Prestamo {
    private Integer cantMaxDias;
    private Integer retraso;
    
    public Prestamo (Integer cantMaxDias, Integer retraso){
        this.cantMaxDias = cantMaxDias;
        this.retraso = retraso;
        
    }

    public Integer getCantMaxDias() {
        return cantMaxDias;
    }

    public void setCantMaxDias(Integer cantMaxDias) {
        this.cantMaxDias = cantMaxDias;
    }

    public Integer getRetraso() {
        return retraso;
    }

    public void setRetraso(Integer retraso) {
        this.retraso = retraso;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "cantMaxDias=" + cantMaxDias + ", retraso=" + retraso + '}';
    }
    
    
    
}
