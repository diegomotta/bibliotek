/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author diego
 */
public class HistorialReparacion {
    private Date IngresoReparación;
    private String estadoReparacion;//En reparación, listo

    public HistorialReparacion(Date IngresoReparación, String estadoReparacion) {
        this.IngresoReparación = IngresoReparación;
        this.estadoReparacion = estadoReparacion;
    }

    public Date getIngresoReparación() {
        return IngresoReparación;
    }

    public void setIngresoReparación(Date IngresoReparación) {
        this.IngresoReparación = IngresoReparación;
    }

    public String getEstadoReparacion() {
        return estadoReparacion;
    }

    public void setEstadoReparacion(String estadoReparacion) {
        this.estadoReparacion = estadoReparacion;
    }

    @Override
    public String toString() {
        return "HistorialReparacion{" + "IngresoReparaci\u00f3n=" + IngresoReparación + ", estadoReparacion=" + estadoReparacion + '}';
    }


}
