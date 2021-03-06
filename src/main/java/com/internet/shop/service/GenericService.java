package com.internet.shop.service;

import java.util.List;

public interface GenericService<T, V> {
    T create(T t);

    T get(V id);

    boolean delete(V id);

    List<T> getAll();
}
