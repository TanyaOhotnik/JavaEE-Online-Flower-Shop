package com.mkr.dao.interfaces;

import java.util.List;

/**
 * Created by Tanya Ohotnik on 10.11.2016.
 */

public interface IRoleDAO<T> extends InterfaceDAO<T> {
   public T findByRoleName(String name);
}
