package com.mkr.dao;

/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */

import com.mkr.dao.interfaces.InterfaceDAO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO<T> implements InterfaceDAO<T> {

    @PersistenceContext(unitName = "ejbEntityManager")
    protected EntityManager em;

    @Override
    public void add(T obj) {
        em.persist(obj);
    }

    @Override
    public void delete(int id) {
        em.remove(find(id));
    }

    @Override
    public void delete(T obj) {
        em.remove(em.merge(obj));
    }

    @Override
    public void update(T obj) {
        em.merge(obj);
    }

    @Override
    public T find(int id) {
        return em.find(getEntityClass(), id);
    }
}
