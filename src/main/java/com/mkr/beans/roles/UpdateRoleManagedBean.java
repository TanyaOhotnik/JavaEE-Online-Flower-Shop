package com.mkr.beans.roles;

import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Role;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "updateRoleManagedBean")
@ViewScoped
public class UpdateRoleManagedBean {
    @EJB
    private IRoleDAO<Role> roleDAO;

    public List<Role> getAll(){
        return roleDAO.getAll();
    }
}
