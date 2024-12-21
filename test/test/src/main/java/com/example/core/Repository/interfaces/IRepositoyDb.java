package com.example.core.Repository.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRepositoyDb<T> extends IRepo<T>{
    void getConnection();
    void closeConnection();
    String generateSql(T data);
    void initPreparedStatment(String sql) throws SQLException;
    void setFields(T data) throws SQLException, IllegalAccessException;
    T convertToObject(ResultSet rs)throws SQLException, IllegalAccessException;
    ResultSet excecuteQuerry() throws SQLException;
    int excecuteUpdate() throws SQLException;
}
