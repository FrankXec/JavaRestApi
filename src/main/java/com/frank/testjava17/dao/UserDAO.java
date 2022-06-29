package com.frank.testjava17.dao;


import com.frank.testjava17.config.PersistenceConnection;
import com.frank.testjava17.dto.UserDTO;
import com.frank.testjava17.interfaces.ICRUD;
import java.util.List;
import jakarta.persistence.*;
import com.frank.testjava17.config.MYSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//Query query = session.createQuery("") //crear query
//entitys = (cast) query.uniqueResult(); // Query query = session.createQuery("from UserDTO WHERE id = 1", UserDTO.class);
//Object[] object = (Object[]) query.uniqueResult(); // Query query = session.createQuery("select nickName, email, password from UserDTO", UserDTO.class);
//SQLQuery slqQuery = session.createSQLQuery("") //sql normal
//sqlQuery.addEntity(Entity.class)
//transform if not need all columns
//sqlQuery.setResultTransformer(Criteria.Alias_to_entity_map)
//List entity = query.list();
//in for -> Map map = (Map)item; -> use map;
public class UserDAO implements ICRUD<UserDTO>{
    private UserDTO entity = null;
    private EntityManager manager = null;
    private boolean status = false;
    private List<UserDTO> entitys = null;

    /*
    @Override
    public List<UserDTO> getAll() {
        String query = "SELECT * FROM USER";
        Connection con = MYSQLConnection.getConnection();
        if(con != null){
            List<UserDTO> list = new ArrayList<>();
            try{
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    list.add(new UserDTO(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    ));
                }
                con.close();
                statement.close();
                resultSet.close();
                return list;
            }catch(Exception ex){
                System.out.println("Error.User.getAll: "+ex);
            }
        }
        return null;
    }
    @Override
    public UserDTO getOneById(String id) {
        String query = "SELECT * FROM USER WHERE ID = ?"; 
        Connection con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement prepareStatement = con.prepareStatement(query);
                prepareStatement.setInt(1, Integer.parseInt(id));
                
                ResultSet result = prepareStatement.executeQuery();
                UserDTO user = null;
                while(result.next()){
                    user = new UserDTO(
                            result.getLong(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6)
                    );
                }
                con.close();
                prepareStatement.close();
                result.close();
                return user;
            }catch(Exception ex){
                System.out.println("Error.User.getOneById: "+ex);
            }
        }
        return null;
    }

    @Override
    public boolean create(UserDTO entity) {
        String query = "INSERT INTO USER(NAME,LASTNAME,NICKNAME,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
        Connection con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
                ps.setString(3, entity.getNickName());
                ps.setString(4, entity.getEmail());
                ps.setString(5, entity.getPassword());
                
                int status = ps.executeUpdate();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.User.Create: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(UserDTO entity) {
        String query = "UPDATE USER SET NAME = ?, NICKNAME = ?, PASSWORD = ? WHERE ID = ?";
        Connection con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getNickName());
                ps.setString(3, entity.getPassword());
                ps.setLong(4, entity.getId());
                
                int status = ps.executeUpdate();
                con.close();
                ps.close();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.User.Update: "+ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM USER WHERE ID = ?";
        Connection con = MYSQLConnection.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setLong(1, Long.parseLong(id));
                
                int status = ps.executeUpdate();
                con.close();
                ps.close();
                if(status == 1){
                    return true;
                }
            }catch(Exception ex){
                System.out.println("Error.User.Delete: "+ex);
            }
        }
        return false;
    }*/

    @Override
    public List<UserDTO> getAll() {
        try{
            manager = PersistenceConnection.getManager();
            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT t FROM UserDTO t", UserDTO.class);
            entitys = query.getResultList();
            manager.getTransaction().commit();
        }catch(Exception ex){
            System.out.println("Error.GetAll.User: "+ex);
        }finally{
            manager.close();
        }
        return entitys;
    }
    
    @Override
    public UserDTO getOneById(String id) {
        try{
            manager = PersistenceConnection.getManager();
            entity = manager.find(UserDTO.class, Long.parseLong(id));
        }catch(Exception ex){
            System.out.println("Error.GetOneById.User: "+ex);
        }finally{
            manager.close();
        }
        return entity;
    }

    @Override
    public boolean create(UserDTO entity) {
        try{
            manager = PersistenceConnection.getManager();
            manager.getTransaction().begin();
            manager.persist(entity);
            //session.detach(object); -> no deja  modificar despues de la insercion
            manager.getTransaction().commit();
            status = true;
        }catch(Exception ex){
            System.out.println("Error.Create.User: "+ex);
        }finally{
            manager.close();
        }
        return status;
    }

    @Override
    public boolean update(UserDTO entity) {
        try{
            manager = PersistenceConnection.getManager();
            manager.getTransaction().begin();
            manager.merge(entity);
            //session.detach(object); -> no deja  modificar despues de la insercion
            manager.getTransaction().commit();
            status = true;
        }catch(Exception ex){
            System.out.println("Error.Update.User: "+ex);
        }finally{
            manager.close();
        }
        return status;
    }

    @Override
    public boolean delete(String id) {
        try{
            manager = PersistenceConnection.getManager();
            manager.getTransaction().begin();
            UserDTO user = manager.find(UserDTO.class, Long.parseLong(id));
            manager.remove(user);
            //session.detach(object); -> no deja  modificar despues de la insercion
            manager.getTransaction().commit();
            status = true;
        }catch(Exception ex){
            System.out.println("Error.Delete.User: "+ex);
        }finally{
            manager.close();
        }
        return status;
    }
}
