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
import java.security.MessageDigest;

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

            if(profileDAO.findByEmail(profile.getEmail())!= null) throw new Exception();
            profile.setRole(roleDAO.findByRoleName("user"));
            profile.setPassword(hashing(profile.getPassword()));
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

    public String hashing(String pass) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }


}