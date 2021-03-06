package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;
import com.mkr.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;
import java.util.Map;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "getProductsManagedBean")
@SessionScoped
public class GetProductsManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;
    private Product product;
    private int productId;
    private int sort;
    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(params != null && params.containsKey("product_id")) {
            productId = Integer.parseInt(params.get("product_id"));
            product = productDAO.find(productId);
        } else {
            product = new Product();
        }
    }
    public List<Product> getProducts(){
        if(sort==0) return getAll();
        if(sort==1) return getAllByAscending();
        if(sort==2) return getAllByDescending();
        return getAllBetweenPrices(1,1);
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
