package com.mkr.dao;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.entities.Order;
import com.mkr.entities.Product;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
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

    @Override
    public List<Order> getAllDelivered() {
            try{
                String query = "SELECT c FROM Order c WHERE c.done = TRUE";
                TypedQuery<Order> namedQuery = em.createQuery(query, Order.class);
                return namedQuery.getResultList();
            }catch (NoResultException ex){
                return null;
            }
    }

    @Override
    public List<Order> getAllUndelivered() {
        try{
            String query = "SELECT c FROM Order c WHERE c.done = FALSE";
            TypedQuery<Order> namedQuery = em.createQuery(query, Order.class);
            return namedQuery.getResultList();
        }catch (NoResultException ex){
            return null;
        }
    }

    @Override
    public List<Order> getAllByUsername(int id) {
        try{
            String query = "SELECT c FROM Order c WHERE c.profile.id LIKE :id";
            TypedQuery<Order> namedQuery = em.createQuery(query, Order.class).setParameter("id",id);
            return namedQuery.getResultList();
        }catch (NoResultException ex){
            return null;
        }
    }
}
