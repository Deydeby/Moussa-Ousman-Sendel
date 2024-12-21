package com.example.core.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.core.Repository.interfaces.IRepo;

public class Repository<T> implements IRepo<T>{
    
    public List<T> data = new ArrayList<>();

    @Override
    public List<T> select(){
        return data;
    }

    @Override
    public void insert(T item){
        data.add(item);
    }
    
}
