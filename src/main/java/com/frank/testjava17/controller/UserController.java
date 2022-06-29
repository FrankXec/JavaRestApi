package com.frank.testjava17.controller;


import com.frank.testjava17.dao.UserDAO;
import com.frank.testjava17.dto.UserDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path(value = "user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private UserDAO dao;
    
    public UserController(){
        dao = new UserDAO();
    }
    
    @GET
    public List<UserDTO> getAll(){
        return dao.getAll();
    }
    
    @GET
    @Path(value = "{id}")
    public UserDTO getOneById(@PathParam(value = "id") String id){
        return dao.getOneById(id);
    }
    
    @POST
    public boolean create(UserDTO entity){
        return dao.create(entity);
    }
    
    @PUT
    public boolean update(UserDTO entity){
        return dao.update(entity);
    }
    
    @DELETE
    @Path(value = "{id}")
    public boolean delete(@PathParam(value = "id") String id){
        return dao.delete(id);
    }
}
