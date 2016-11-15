package com.mkr.beans.profile;

import com.mkr.dao.RoleDAO;
import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.dao.interfaces.IRoleDAO;
import com.mkr.entities.Product;
import com.mkr.entities.Profile;
import com.mkr.entities.Role;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "addGetProfileManagedBean", eager = true)
@SessionScoped
public class AddGetProfileManagedBean {
    @EJB
    private IProfileDAO<Profile> profileDAO;
    @EJB
    private IRoleDAO<Role> roleDAO;
    private Profile profile;
    private int profileId;
    private String password;

    @PostConstruct
    public void init() {
        profile = new Profile();
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void delete(long id) {
        profileDAO.delete((int) id);
    }

    public void addProfile() {


        try{
//            product.setImg("../resources/images/"+product.getImg());
            profile.setRole(roleDAO.findByRoleName("user"));
            profileDAO.update(profile);
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Поздравляем, вы зарегестрированы!"));
            profile = new Profile();
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Произошла ошибка, существует аккаунт с указанным e-mail!"));
        }

    }

    public Profile findProfile() {
        if (profileId > 0) {
            profile = profileDAO.find(profileId);
        }
        return profile;
    }

    public void validateEmail(FacesContext context, UIComponent comp,
                              Object value) {

        String email = (String) value;
        if (email==null) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Поле является обязательным");
            context.addMessage(comp.getClientId(context), message);
            return;
        }
        Profile profileFromDB = profileDAO.findByEmail(email);
        if (profileFromDB != null) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Пользователь с таким e-mail уже существует");
            context.addMessage(comp.getClientId(context), message);
            return;
        }
        if (!email.contains("@")) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Неверный формат e-mail");
            context.addMessage(comp.getClientId(context), message);
        }

    }

    public void validatePhone(FacesContext context, UIComponent comp,
                                Object value) {
        String phone = (String) value;
        if (phone==null) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Поле является обязательным");
            context.addMessage(comp.getClientId(context), message);
            return;
        }
        boolean flag = true;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                flag = false;
                break;
            }
        }
        if (phone.length() !=10 && flag) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Неверный формат номера");
            context.addMessage(comp.getClientId(context), message);

        }
    }
    public void validatePassword(FacesContext context, UIComponent comp,
                              Object value) {

        String pass = (String) value;

        if (pass==null) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Поле является обязательным");
            context.addMessage(comp.getClientId(context), message);
            return;
        }

        if (!pass.equals(password)) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Пароли не совпадают");
            context.addMessage(comp.getClientId(context), message);

        }
    }
    public void validateNull(FacesContext context, UIComponent comp,
                                Object value) {

        String validate = (String) value;

        if (validate==null) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "Поле является обязательным");
            context.addMessage(comp.getClientId(context), message);

        }

    }
}