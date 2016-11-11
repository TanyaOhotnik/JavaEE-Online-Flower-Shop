package com.mkr.dao.interfaces;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

public interface IProfileDAO<T> extends InterfaceDAO<T> {
    public T findByEmail(String email);
}
