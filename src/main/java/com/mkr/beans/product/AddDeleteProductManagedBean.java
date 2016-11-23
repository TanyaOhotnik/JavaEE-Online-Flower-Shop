package com.mkr.beans.product;

import com.mkr.beans.LoginManageBean;
import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "addDeleteProductManagedBean", eager = true)
@RequestScoped
public class AddDeleteProductManagedBean {
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
        FacesContext.getCurrentInstance().addMessage("test1",
                new FacesMessage("hello!"));
        try{
            if(vendorCode==0) throw new Exception("no vendor code");
            productDAO.delete(findByCode().getId());
            FacesContext.getCurrentInstance().addMessage("test1",
                    new FacesMessage("Товар удален из базы!"));
        } catch (Exception e){

            FacesContext.getCurrentInstance().addMessage("test1",
                    new FacesMessage( e.getMessage()));
        }

    }
    @Remove
    public void addProduct() {
//        byte[] contents = file.getContents();
//        product.setImg(contents);
        try{
           if(productDAO.findByVendorCode(product.getVendorCode())!=null) {
               FacesContext.getCurrentInstance().addMessage("test",
                       new FacesMessage("Товар c таким артикулом уже существует!"));
               return;
           }
            product.setImg("../resources/images/"+product.getImg());
            productDAO.add(product);
            Logger.getLogger(AddDeleteProductManagedBean.class.getName()).log(Level.SEVERE, "add item successful");
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Товар добавлен в базу!"));
            product = new Product();
        } catch (Exception e){
            Logger.getLogger(AddDeleteProductManagedBean.class.getName()).log(Level.SEVERE, "add item failed");
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Произошла ошибка, товар не добавлен в базу!"));
        }
    }

    public Product findByCode() {
        if(this.vendorCode >0){
                product =  productDAO.findByVendorCode(this.vendorCode);
    }
        return product;
    }

//    public UploadedFile getFile() {
//        return file;
//    }
//
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }
}
