/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dao.Producto;
import org.dto.ProductoFacadeLocal;

@Named(value = "listarProductos")
@ViewScoped
public class ListarProductos implements Serializable{

    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    private List<Producto> listaProductos = new ArrayList<Producto>();

    public ListarProductos() {
    }
    
    @PostConstruct
    public void init(){
        listaProductos = productoFacadeLocal.findAll();
    
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

}
