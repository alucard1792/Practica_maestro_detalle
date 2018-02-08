/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dao.FacturaDetalle;

/**
 *
 * @author David
 */
@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> implements FacturaDetalleFacadeLocal {

    @PersistenceContext(unitName = "EjercicioMaestroDetallePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaDetalleFacade() {
        super(FacturaDetalle.class);
    }
    
}
