package com.mkr.beans;

import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Role;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "roleManagedBean")
@RequestScoped
public class RoleManagedBean {
    @EJB
    private IRoleDAO<Role> roleDAO;

    public List<Role> getAll(){
        return roleDAO.getAll();
    }
}
