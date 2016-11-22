package com.mkr.beans.profile;

import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Profile;
import com.sun.xml.internal.bind.v2.TODO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "updateProfileManagedBean")
@RequestScoped
public class UpdateProfileManagedBean {
    @EJB
    private IProfileDAO<Profile> profileDAO;
    private Profile profile;
    private int profileId;
    @PostConstruct
    public void init() {
//        profile = profileDAO.findByEmail("kvara@gmail.com");
//        profile = new Profile();
        /*find profile by user id*/
//        TODO
//                CHECK
        profile = profileDAO.findByEmail(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().toString());
        profileId = profile.getId();
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

    public void update() {
        try{
        profileDAO.update(profile);
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Ваши данные успешно сохранены."));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Произошла ошибка, ваши данные не будут сохранены."));
        }
    }
    
    public Profile findProfile() {
//        if(profileId>0){
//            profile =  profileDAO.find(profileId);
//        }
//        return profile;
        return profileDAO.findByEmail("kvara@gmail.com");
    }
    public Profile findProfileB() {

            profile =  profileDAO.findByEmail("kvara@gmail.com");

        return profile;
    }
    public List<Profile> getAll(){
        return profileDAO.getAll();
    }
}
