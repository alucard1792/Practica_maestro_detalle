/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.dao.Factura;
import org.dao.FacturaDetalle;
import org.dao.Producto;
import org.dao.customDAOs.FacturaCustom;
import org.dto.FacturaDetalleFacadeLocal;
import org.dto.FacturaFacadeLocal;
import org.dto.ProductoFacadeLocal;

@Named(value = "crearFactura")
@ConversationScoped
public class CrearFactura implements Serializable {

    @EJB
    private FacturaFacadeLocal facturaFacadeLocal;
    @EJB
    private FacturaDetalleFacadeLocal FacturaDetalleFacadeLocal;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    @Inject
    private Conversation conversacion;
    private FacturaDetalle facturaDetalle;
    private Factura factura;
    private Integer totalCompra = 0;
    private List<FacturaDetalle> listaFacturaDetalle;

    public CrearFactura() {

    }

    @PostConstruct
    public void init() {
        listaFacturaDetalle = new ArrayList<>();
    }

    public void crearNuevaFactura() {
        facturaFacadeLocal.create(factura);
    }

    public void agregarProductoFactura(Producto producto) {
        iniciarConversacion();
        if (factura == null) {
            factura = new Factura();
            factura.setFecha(new Date());

        }
        if (validarStock(producto)) {
            facturaDetalle = new FacturaDetalle(null, 1, producto.getPrecio(), factura, producto);
            listaFacturaDetalle.add(facturaDetalle);
            factura.setFacturaDetalleList(listaFacturaDetalle);
            producto.setStock(producto.getStock() - 1);
            productoFacadeLocal.edit(producto);
            System.out.println(producto.getNombre());

        }

    }

    public void registrarFactura() {
        facturaFacadeLocal.create(factura);
        terminarConversacion();
        factura = null;
        totalCompra = 0;
    }

    public boolean validarStock(Producto producto) {
        boolean bandera = false;
        if (producto.getStock() != 0) {
            bandera = true;
        }
        return bandera;

    }
    
    public void calcularTotal(){
        for(FacturaDetalle facturaDetalle:factura.getFacturaDetalleList()){
            totalCompra += facturaDetalle.getPrecio();
        }
        
    }

    private void iniciarConversacion() {
        if (conversacion.isTransient()) {
            conversacion.begin();

        }

    }

    private void terminarConversacion() {
        if (!conversacion.isTransient()) {
            conversacion.end();

        }

    }

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<FacturaDetalle> getListaFacturaDetalle() {
        return listaFacturaDetalle;
    }

    public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
        this.listaFacturaDetalle = listaFacturaDetalle;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

}
