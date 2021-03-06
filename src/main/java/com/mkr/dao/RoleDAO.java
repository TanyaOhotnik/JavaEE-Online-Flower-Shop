package com.mkr.dao;

import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Product;
import com.mkr.entities.Role;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@Stateless
@Local(IRoleDAO.class)
public class RoleDAO extends AbstractDAO<Role> implements IRoleDAO<Role> {
    @Override
    public List<Role> getAll() {
        String query = "SELECT c FROM Role c";
        TypedQuery<Role> namedQuery = em.createQuery(query, Role.class);
        return namedQuery.getResultList();
    }

    @Override
    public Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    public Role findByRoleName(String name) {
        try{
        String query = "SELECT c FROM Role c WHERE c.name LIKE :name";
        TypedQuery<Role> namedQuery = em.createQuery(query, Role.class).setParameter("name",name);
        return namedQuery.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
