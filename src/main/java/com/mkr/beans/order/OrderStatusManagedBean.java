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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

@ManagedBean(name = "orderStatusManagedBean", eager = true)
@RequestScoped
public class OrderStatusManagedBean {
    @EJB
    private IOrderDAO<Order> orderDAO;


    public void setDone(Order o){
            o.setDone(true);
            orderDAO.update(o);
    }


    public boolean validate(){

        return true;

    }

}
