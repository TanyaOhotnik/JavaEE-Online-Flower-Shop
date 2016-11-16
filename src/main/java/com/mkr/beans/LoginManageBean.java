package com.mkr.beans;



import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Profile;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by olgasaliy on 14.11.16.
 */
//@Named(value = "userController")

@ManagedBean(name = "loginManageBean")
@SessionScoped
public class LoginManageBean implements Serializable {

    @EJB
    private IProfileDAO<Profile> profileDAO;
    private String username;
    private String password;
    private Profile profile;

    public LoginManageBean() {
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String result;

        try {
            request.login(username, password);
            profile = profileDAO.findByEmail(username);
            if (isAdmin()) {
                result = "admin/manage?faces-redirect=true";
            } else {
                result = "index?faces-redirect=true";
            }

        } catch (ServletException ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

            result = "loginError?faces-redirect=true";
        }

        return result;
    }


    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            profile = null;
            request.logout();
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();


        } catch (ServletException ex) {

//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            return "/index";
        }
    }

//    public CustomerEJB getEjbFacade() {
//        return ejbFacade;
//    }

    public  Profile getAuthenticatedUser() {
        return profile;
    }

    public boolean isLogged() {
        if (FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null) {
            profile = profileDAO.findByEmail(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().toString());
            return true;
        } else {
            return false;
        }
    }
//
    public boolean isAdmin() {
       if(profile.getRole().getName()=="admin") return true;
        return false;
    }
//
//    public String goAdmin() {
//        if (isAdmin()) {
//            return "/admin/index";
//        } else {
//            return "index";
//        }
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


}
