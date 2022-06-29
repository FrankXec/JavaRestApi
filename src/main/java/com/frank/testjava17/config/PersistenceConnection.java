package com.frank.testjava17.config;

import jakarta.persistence.*;

public class PersistenceConnection {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
    private static EntityManager manager;
    
    public static EntityManager getManager(){
        try{
            manager = emf.createEntityManager();
            return manager;
        }catch(Exception ex){
            System.out.println("Error.getManager: "+ex);
            return null;
        }
    }
}
