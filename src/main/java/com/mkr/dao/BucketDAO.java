package com.mkr.dao;

import com.mkr.dao.interfaces.IBucketDAO;
import com.mkr.entities.Bucket;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@Stateless
@Local(IBucketDAO.class)
public class BucketDAO extends AbstractDAO<Bucket> implements IBucketDAO<Bucket>{
    @Override
    public List<Bucket> getAll() {
        String query = "SELECT c FROM Bucket c";
        TypedQuery<Bucket> namedQuery = em.createQuery(query, Bucket.class);
        return namedQuery.getResultList();
    }

    @Override
    public Class<Bucket> getEntityClass() {
        return Bucket.class;
    }

}
