package com.mkr.beans.product;

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
    public void delete() {
        try{

            productDAO.delete(productDAO.findByVendorCode(vendorCode));
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Товар удален из базы!"));
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Произошла ошибка, товар не будет удален!"));
        }





    }
    @Remove
    public void addProduct() {
//        byte[] contents = file.getContents();
//        product.setImg(contents);
        try{
           if(validate()) throw new Exception();
//            product.setImg("../resources/images/"+product.getImg());
            productDAO.add(product);
            FacesContext.getCurrentInstance().addMessage("test",
                    new FacesMessage("Товар добавлен в базу!"));
            product = new Product();
        } catch (Exception e){
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
    public boolean validate(){
        if(product.getName()==null || product.getImg() ==null
                || product.getPrice()==0 || product.getDescription()==null || product.isAvailable()){
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
