/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dao.Factura;
import org.dto.FacturaFacadeLocal;

@Named(value = "listarFacturas")
@ViewScoped
public class ListarFacturas implements Serializable{

    @EJB
    private FacturaFacadeLocal facturaFacadeLocal;
    private List<Factura>listaFacturas;
    
    public ListarFacturas() {
        listaFacturas = facturaFacadeLocal.findAll();
        
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }
    
}
