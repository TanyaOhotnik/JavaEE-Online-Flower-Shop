package com.mkr.dao;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.entities.Order;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@Stateless
@Local(IOrderDAO.class)
public class OrderDAO extends AbstractDAO<Order> implements IOrderDAO<Order>{
    @Override
    public List<Order> getAll() {
        String query = "SELECT c FROM Order c";
        TypedQuery<Order> namedQuery = em.createQuery(query, Order.class);
        return namedQuery.getResultList();
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

}
