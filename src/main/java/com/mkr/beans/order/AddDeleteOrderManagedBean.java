package com.mkr.beans.order;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Order;
import com.mkr.entities.Product;
import com.mkr.entities.Profile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

@ManagedBean(name = "addDeleteOrderManagedBean", eager = true)
@SessionScoped
public class AddDeleteOrderManagedBean {
    @EJB
    private IOrderDAO<Order> orderDAO;
    @EJB
    private IProductDAO<Product> productDAO;
    @EJB
    private IProfileDAO<Profile> profileDAO;
    private Order order;
    private int summary;
    private Date date = new Date();
    private List<Order> orderList;
    @PostConstruct
    public void init() {

        order = new Order();
        orderList = new ArrayList<Order>();
        summary = 0;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void deleteOrder(Order o,String username) {
        try{
        orderList.remove(o);
        summary-=o.getProduct().getPrice();
        if(orderList.size()>0)
        order = orderList.get(0);
        else order = new Order();
        }catch (Exception e){
            Logger.getLogger(AddDeleteOrderManagedBean.class.getName()).log(Level.SEVERE, "remove failed, server problems");
        }
    }


    public void addOrder(int productId, String username) {

            order.setProduct(productDAO.find(productId));
            order.setProfile(profileDAO.findByEmail(username));
//        System.out.println(order.getProduct().toString());
//        System.out.println(order.getProfile().getEmail());
            summary+=order.getProduct().getPrice();
            orderList.add(order);
            order = new Order();

    }

    public void saveChanges(){
        try {
            for (Order o : orderList) {
                o.setAddress(order.getAddress());
                o.setDate(date.toString());
//            o.setDate(order.getDate());
                o.setAddresseeName(order.getAddresseeName());
                o.setDone(false);
                orderDAO.update(o);
            }
            orderList = new ArrayList<Order>();
            order = new Order();
            summary = 0;
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Ваш заказ принят, менеджер свяжется с вами"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Возники проблемы, попробуйте позже"));
            Logger.getLogger(AddDeleteOrderManagedBean.class.getName()).log(Level.SEVERE, "order failed");
        }
    }


    public boolean validate(){

        return true;

    }

    public int getSummary() {
        return summary;
    }

    public void setSummary(int summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
