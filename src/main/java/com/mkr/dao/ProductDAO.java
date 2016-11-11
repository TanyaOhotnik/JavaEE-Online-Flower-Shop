package com.mkr.dao;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@Stateless
@Local(IProductDAO.class)
public class ProductDAO extends AbstractDAO<Product> implements IProductDAO<Product>{
    @Override
    public List<Product> getAll() {
        String query = "SELECT c FROM Product c";
        TypedQuery<Product> namedQuery = em.createQuery(query, Product.class);
        return namedQuery.getResultList();
    }

    @Override
    public Class<Product> getEntityClass() {
        return Product.class;
    }
    @Override
    public List<Product> getAllByAscending(){
        String query = "SELECT c FROM Product c ORDER BY c.price";
        TypedQuery<Product> namedQuery = em.createQuery(query, Product.class);
        return namedQuery.getResultList();
    }
    @Override
    public List<Product> getAllByDescending(){
        String query = "SELECT c FROM Product c ORDER BY c.price DESC";
        TypedQuery<Product> namedQuery = em.createQuery(query, Product.class);
        return namedQuery.getResultList();
    }

    @Override
    public List<Product> getAllBetweenPrices(int min, int max) {
        String query = "SELECT c FROM Product c WHERE c.price >= :min AND c.price <= :max";
        TypedQuery<Product> namedQuery = em.createQuery(query, Product.class).setParameter("min",min).setParameter("max",max);
        return namedQuery.getResultList();
    }

}
