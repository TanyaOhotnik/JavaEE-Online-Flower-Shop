package com.mkr.beans.profile;

import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Profile;
import com.mkr.entities.Role;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

@ManagedBean(name = "profileRoleManagedBean", eager = true)
@RequestScoped
public class ProfileRoleManagedBean {
    @EJB
    private IProfileDAO<Profile> orderDAO;
    @EJB
    private IRoleDAO<Role> roleDAO;

    public void addAdmin(Profile o){
            o.setRole(roleDAO.findByRoleName("admin"));
            orderDAO.update(o);
    }

}
