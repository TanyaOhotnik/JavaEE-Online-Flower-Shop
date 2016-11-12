package com.mkr.dao;

import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Profile;
import com.mkr.entities.Profile;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@Stateless
@Local(IProfileDAO.class)
public class ProfileDAO extends AbstractDAO<Profile> implements IProfileDAO<Profile> {
    @Override
    public List<Profile> getAll() {
        String query = "SELECT c FROM Profile c";
        TypedQuery<Profile> namedQuery = em.createQuery(query, Profile.class);
        return namedQuery.getResultList();
    }

    @Override
    public Class<Profile> getEntityClass() {
        return Profile.class;
    }


    @Override
    public Profile findByEmail(String email) {
        try{
        String query = "SELECT c FROM Profile c WHERE c.email LIKE :email";
        TypedQuery<Profile> namedQuery = em.createQuery(query, Profile.class).setParameter("email", email);
        return namedQuery.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
