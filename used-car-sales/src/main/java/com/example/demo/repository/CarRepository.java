package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

import java.util.*;
@Repository
public class CarRepository {

 

    @Autowired
    private JdbcTemplate template;
    
    public int addCar(Car entity) {
        
        SimpleJdbcInsert inserter=new SimpleJdbcInsert(template);
        
        inserter.withTableName("cars").usingColumns("model","year","kilometers","brand","staus");
        BeanPropertySqlParameterSource sql =new BeanPropertySqlParameterSource(entity);
        return inserter.execute(sql);
        
    }
    
    
    public List<Car> getAllCars(){
        
        String sql="select * from cars";
        
        List<Car> carList=
                template.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
        
        return carList;
        
        
    }
    
    
    public List<Car> getAvailableCars(){
        
        String sql="select * from cars where staus='unsold'";
        
        List<Car> caravailableList=
                template.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
        
        return caravailableList;
        
        
    }
    public List<Car> getsCarsByBrand(String brand)
    {

     

        
    String sql="select * from cars where brand=?";    
        List<Car> cars=
                template.query(sql,new Object[]{brand},new BeanPropertyRowMapper<>(Car.class));
        
        return cars;
        
        
    }

     

    public String[] getBrand()
    {
    String sql="select distinct(brand) from cars";
    List<String> list = template.queryForList(sql,String.class);
    String[] brands=list.toArray(new String[list.size()]);

     

    return brands;

     

    }
}
 