package com.mkr.beans.product;

import com.mkr.dao.interfaces.IProductDAO;
import com.mkr.entities.Product;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */
@ManagedBean(name = "addDeleteProductManagedBean")
@RequestScoped
public class AddDeleteProductManagedBean {
    @EJB
    private IProductDAO<Product> productDAO;
    private Product product;
    private int productId;
    private UploadedFile file;
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
    public void delete(long id) {
        productDAO.delete((int)id);
    }

    public void addProduct() {
        byte[] contents = file.getContents();
        product.setImg(contents);
        productDAO.add(product);
    }

    public Product findProduct() {
        if(productId>0){
                product =  productDAO.find(productId);
    }
        return product;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
