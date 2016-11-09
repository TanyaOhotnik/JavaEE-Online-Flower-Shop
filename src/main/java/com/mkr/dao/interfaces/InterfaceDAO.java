package com.mkr.dao.interfaces;

import java.util.List;
/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */
public interface InterfaceDAO<T> {
    void add(T obj);

    void delete(int id);

    void delete(T obj);

    void update(T obj);

    T find(int id);

    List<T> getAll();

    Class<T> getEntityClass();
}
