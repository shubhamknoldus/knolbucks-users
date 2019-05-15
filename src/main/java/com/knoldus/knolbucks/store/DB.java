package com.knoldus.knolbucks.store;

import java.util.List;

public interface DB<T> {
    T getById(String id);

    T updateUser(String id);

    List<T> getAll();

    boolean store(T obj);
}
