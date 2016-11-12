package com.mkr.beans.order;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Order;
import com.mkr.entities.Product;
import com.mkr.entities.Profile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "addDeleteOrderManagedBean", eager = true)
@RequestScoped
public class AddDeleteOrderManagedBean {
    @EJB
    private IOrderDAO<Order> orderDAO;
    @EJB
    private IProductDAO<Product> productDAO;
    @EJB
    private IProfileDAO<Profile> profileDAO;
    private Order order;
    @PostConstruct
    public void init() {
        order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void deleteOrder() {

    }

    public void addOrder(int productId) {

//        try{
//           if(!validate()) throw new Exception();
            order.setProduct(productDAO.find(productId));
            order.setProfile(profileDAO.find(1));
            orderDAO.update(order);

//        } catch (Exception e){
//
//        }
    }


    public boolean validate(){

        return true;

    }

}
