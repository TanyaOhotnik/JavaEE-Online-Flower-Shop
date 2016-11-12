package com.mkr.beans.order;

import com.mkr.dao.interfaces.IOrderDAO;
import com.mkr.entities.Order;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "getOrdersManagedBean")
@RequestScoped
public class GetOrdersManagedBean {
    @EJB
    private IOrderDAO<Order> orderDAO;
    private Order order;
    private int orderId;
    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(params != null && params.containsKey("order_id")) {
            int orderId = Integer.parseInt(params.get("order_id"));
            order = orderDAO.find(orderId);
        } else {
            order = new Order();
        }
    }

    public List<Order> getAll(){
        return orderDAO.getAll();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
