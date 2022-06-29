package com.frank.testjava17.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class MYSQLConnection {
    private static Connection conn;
    private final static String url = "jdbc:mysql://localhost:3306";
    private final static String dbName = "testdb?useSSL=FALSE";
    private final static String user = "root";
    private final static String password = "";
            
    public static Connection getConnection(){
        //Conexion
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url+'/'+dbName, user, password);
            return conn;
        }catch(Exception ex){
            System.out.println("Error.Connection.MYSQL: "+ex);
            return null;
        }
    }
}
