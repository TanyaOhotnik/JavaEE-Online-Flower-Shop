package com.mkr.dao;

/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */

import com.mkr.dao.interfaces.ISpecializationDAO;
import com.mkr.entities.Specialization;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */
@Stateless
@Local(ISpecializationDAO.class)
public class SpecializationDAO extends AbstractDAO<Specialization> implements ISpecializationDAO<Specialization> {

    @Override
    public Class<Specialization> getEntityClass() {
        return Specialization.class;
    }
    @Override
    public List<Specialization> getAll() {
        String query = "SELECT c FROM Specialization c";
        TypedQuery<Specialization> namedQuery = em.createQuery(query, Specialization.class);
        return namedQuery.getResultList();
    }

}