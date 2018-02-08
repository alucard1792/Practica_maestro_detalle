/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.customDAOs;

import org.dao.Factura;
import org.dao.FacturaDetalle;

/**
 *
 * @author David
 */
public class FacturaCustom {
    private Factura facturaId;
    private FacturaDetalle facturaDetalle;

    public FacturaCustom() {
        facturaId = new Factura();;
        facturaDetalle = new FacturaDetalle();
        
    }

    public Factura getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Factura facturaId) {
        this.facturaId = facturaId;
    }

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

}
