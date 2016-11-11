package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "updateProductManagedBean")
@ViewScoped
public class UpdateProductManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;
    private Product product;
    private int productId;
    @PostConstruct
    public void init() {
        product = new Product();
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

    public void update() {
        productDAO.update(product);
    }
    
    public Product findProduct() {
        if(productId>0){
            product =  productDAO.find(productId);
        }
        return product;
    }
}
