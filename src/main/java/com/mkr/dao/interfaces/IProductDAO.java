package com.mkr.dao.interfaces;

import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

public interface IProductDAO<T> extends InterfaceDAO<T> {
    public List<T> getAllByAscending();
    public List<T> getAllByDescending();
    public List<T> getAllBetweenPrices(int min,int max);
}
