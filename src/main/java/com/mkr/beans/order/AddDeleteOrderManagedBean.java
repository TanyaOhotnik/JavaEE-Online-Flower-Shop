package com.mkr.beans.order;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.dao.interfaces.IProfileDAO;
import com.mkr.entities.Order;
import com.mkr.entities.Product;
import com.mkr.entities.Profile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteOrder() {

    }

    public void addOrder(int productId) {

//        try{
//           if(!validate()) throw new Exception();

            order.setProduct(productDAO.find(productId));
            order.setProfile(profileDAO.find(1));
            summary+=order.getProduct().getPrice();
            orderList.add(order);

            order = new Order();
//        } catch (Exception e){
//        }
    }

    public void saveChanges(){
        for(Order o: orderList){
            o.setAddress(order.getAddress());
            o.setDate(order.getDate());
            orderDAO.update(o);
        }
        order = new Order();
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
}
