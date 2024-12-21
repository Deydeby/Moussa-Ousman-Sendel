package com.example.core.Repository.interfaces;

import java.util.List;

public interface IRepo<T> {
    List<T> select();
    void insert(T item);
}
