package com.frank.testjava17.controller;

import com.frank.testjava17.dao.ProductTypeDAO;
import com.frank.testjava17.dto.ProductTypeDTO;
import java.util.List;


public class ProductTypeController {
    private ProductTypeDAO dao;
    
    public ProductTypeController(){
        dao = new ProductTypeDAO();
    }
    
    public List<ProductTypeDTO> getAll(){
        return dao.getAll();
    }
    
    public ProductTypeDTO getOneById(String id){
        return dao.getOneById(id);
    }
    
    public boolean create(ProductTypeDTO entity){
        return dao.create(entity);
    }
    
    public boolean update(ProductTypeDTO entity){
        return dao.update(entity);
    }
    
    public boolean delete(String id){
        return dao.delete(id);
    }
}
