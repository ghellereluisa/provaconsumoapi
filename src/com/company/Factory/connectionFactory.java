package com.company.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class connectionFactory {
    public Connection getConexao(){
        Connection con = null;

        try{
            String url = "jdbc:mysql://localhost:3306/cinema?user=root&password=";
            con = DriverManager.getConnection(url);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return con;
    }
}