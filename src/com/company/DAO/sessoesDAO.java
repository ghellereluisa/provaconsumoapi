package com.company.DAO;


import com.company.Factory.connectionFactory;
import com.company.model.Sessoes;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sessoesDAO {
    private Connection con;

    public sessoesDAO(){
        this.con = new connectionFactory().getConexao();
        PreparedStatement stmt = null;

    }

    public void criarTabela(){
        String sql = "create table if not exists Sessoes(" +
                "id int not null primary key auto_increment," +
                "nomeFilme varchar(30)," +
                "horario varchar(5)," +
                "numSala int";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void inserir(Sessoes sessoes){
        String sql = "insert into cinema values(?, ?, ?)";

        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sessoes.getNomeFilme());
            stmt.setString(2, sessoes.getHorario());
            stmt.setInt(3, sessoes.getNumSala());

            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}

