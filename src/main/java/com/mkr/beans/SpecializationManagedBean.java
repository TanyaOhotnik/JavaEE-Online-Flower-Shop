package com.mkr.beans;

/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */


import com.mkr.dao.interfaces.ISpecializationDAO;
import com.mkr.entities.Specialization;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@ManagedBean(name = "specializationManagedBean", eager = true)
@RequestScoped
public class SpecializationManagedBean {

    static Logger log = Logger.getLogger(SpecializationManagedBean.class.getName());

    @EJB
    private ISpecializationDAO<Specialization> specializationDAO;

    private Specialization specialization;
    private int specializationId;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(params != null && params.containsKey("id")) {
            int spId = Integer.parseInt(params.get("id"));
            specialization = specializationDAO.find(spId);
        } else {
            specialization = new Specialization();
        }

    }

    public List<Specialization> getAllSpecializations() {
        return specializationDAO.getAll();
    }
    public Specialization getSpecialization() {
        return specialization;
    }
    public Specialization getSpecializationById(int specializationId) {
        return specializationDAO.find(specializationId);
    }
    public int getSpecializationId() {
        return specializationId;
    }
    public void edit() { specializationDAO.update(specialization); }
    public void delete() {
        specializationDAO.delete((int)specializationId);
    }
    public void delete(int id) {
        specializationDAO.delete(id);
    }

    public void addSpecialization() {
        specializationDAO.add(specialization);
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }
}
