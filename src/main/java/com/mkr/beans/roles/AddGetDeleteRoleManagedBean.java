package com.mkr.beans.roles;

import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Role;
import com.mkr.entities.Role;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "addGetRoleManagedBean")
@RequestScoped
public class AddGetDeleteRoleManagedBean {
    @EJB
    private IRoleDAO<Role> roleDAO;
    private Role role;
//    private String rolename;
    
    @PostConstruct
    public void init() {
        role = new Role();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public String getRolename() {
//        return rolename;
//    }
//
//    public void setRolename(String rolename) {
//        this.rolename = rolename;
//    }


    public void delete(long id) {
        roleDAO.delete((int)id);
    }

    public void addProduct() {
        roleDAO.add(role);
    }

    public Role findRole() {
        return roleDAO.findByRoleName("user");
    }
    public List<Role> getAll(){
        return roleDAO.getAll();
    }
}
