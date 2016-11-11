package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;
import com.mkr.entities.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "getProductsManagedBean")
@RequestScoped
public class GetProductsManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;

    public List<Product> getAll(){
        return productDAO.getAll();
    }

    public List<Product> getAllByAscending(){
        return productDAO.getAllByAscending();
    }

    public List<Product> getAllByDescending(){
        return productDAO.getAllByDescending();
    }

    public List<Product> getAllBetweenPrices(int min, int max){
        return productDAO.getAllBetweenPrices(min, max);
    }
}
