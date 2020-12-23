/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author otsaan
 */
public class Database {
	
    private static Database instance = new Database();

    private  Connection conn;
    private  ResultSet rs;
    private  Statement st;


    private Database() {}

    public static  Database getInstance() {
        return instance;
    }	

    // est ce que elle a le dorit d'ajouter un patient dans le mm jour du consultation ?
    // r u here !
    //oui do u know if this app allow tht or not ? nop!  okay
    public void connect() throws ClassNotFoundException, SQLException {
        if (conn != null)
            return;
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medcinium","root","");
 
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = String.format("jdbc:mysql://localhost:3306/medcinium", 3306);
//        conn = DriverManager.getConnection(url, "root", "");
    }
        
        
    /**
    * Run a SELECT query
    * @param q la requete
    */
    public  ResultSet query(String q) {
        
        try {
            connect();
            st = conn.createStatement();
            rs = st.executeQuery(q);
            
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Error Message : problem in query() method." + e);
        } 
        
        return rs;
    }
    
    /**
     * Run a query of type DML statement,
     * as INSERT, UPDATE ou DELETE 
     * @param q la requete
     */
    public  int dmlQuery(String q) {
        try {
            connect();
            st = conn.createStatement();
            return st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
            
        } catch (Exception e) {
            System.err.println("Error Message : problem in dmlQuery() method."+e);
        } 
        
        return 0;
    }
   
    public  int dmlQuery2(String q) {
        try {
            connect();
            int insertedId = 0;
            st = conn.createStatement();
            int num = st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                insertedId=rs.getInt(1);
               }
            return insertedId;
            
        } catch (Exception e) {
            System.err.println("Error Message : problem in dmlQuery() method." + e);
        } 
        
        return 0;
    }
	
    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection" + e);
            }
        }

        conn = null;
    }
	
}

