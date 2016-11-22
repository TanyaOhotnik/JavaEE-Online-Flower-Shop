package com.mkr.dao.interfaces;

import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

public interface IOrderDAO<T> extends InterfaceDAO<T> {
    public List<T> getAllDelivered();
    public List<T> getAllUndelivered();
    public List<T> getAllByUsername(int id);
}
