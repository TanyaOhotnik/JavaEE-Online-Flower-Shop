package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "updateProductManagedBean")
@SessionScoped
public class UpdateProductManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;
    private Product product;
    private int productId;
    private int vendorCode;
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

//    public void update() {
//        productDAO.update(product);
//    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Product findProduct() {
        if(productId>0){
            product =  productDAO.find(productId);
        }
        return product;
    }
    public Product findByCode() {
        if(this.vendorCode >0){
            product =  productDAO.findByVendorCode(this.vendorCode);
            if(product==null) {
                FacesContext.getCurrentInstance().addMessage("test1",
                        new FacesMessage("Товар не найден, проверьте артикул."));
            }
        }
        return product;
    }
    public void updateProduct(){
        try{

            productDAO.update(product);
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Данные товара обновлены!"));
            product = new Product();
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Произошла ошибка, данные товара не будут обновлены!"));
        }
    }
}
