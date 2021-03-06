package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "deleteProductManagedBean", eager = true)
@SessionScoped
public class DeleteProductManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;
    private Product product;
    private int vendorCode;
//    private UploadedFile file;
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

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void deleteProduct() {

        try{

            productDAO.delete(findByCode());
            vendorCode = 0;
            product = new Product();
            Logger.getLogger(AddDeleteProductManagedBean.class.getName()).log(Level.INFO, "delete item successful");
            FacesContext.getCurrentInstance().addMessage("test1",
                    new FacesMessage("Товар удален из базы!"));

        } catch (Exception e){
            Logger.getLogger(DeleteProductManagedBean.class.getName()).log(Level.SEVERE, "delete item failed");

            FacesContext.getCurrentInstance().addMessage("test1",
                    new FacesMessage( "Произошла ошибка, товар не будет удален из базы!"));
        }

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
    public boolean validate(){
        if(product.getName()==null || product.getImg() ==null
                || product.getPrice()==0 || product.getDescription()==null){
            return false;
        }
        if(Integer.toString(product.getVendorCode()).length()!=5) return false;
        return true;

    }
//    public UploadedFile getFile() {
//        return file;
//    }
//
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }
}
