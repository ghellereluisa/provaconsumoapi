package com.example.provaapi.DAO;

import com.example.provaapi.Factory.ConnectionFactory;
import com.example.provaapi.Model.Sessoes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessoesDAO {
    private Connection con;

    public SessoesDAO() {
        this.con = new ConnectionFactory().getConexao();
        PreparedStatement stmt = null;

    }

    public void criarTabela() {
        String sql = "create table if not exists Sessoes(" +
                "id int not null primary key auto_increment," +
                "nomeFilme varchar(30)," +
                "horario varchar(5)," +
                "numSala int";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void inserir(Sessoes sessoes) {
        String sql = "insert into cinema values(?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sessoes.getNomeFilme());
            stmt.setString(2, sessoes.getHorario());
            stmt.setInt(3, sessoes.getNumSala());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public List<Sessoes> buscarSessoes(){
        String sql = "select * from Sessoes";

        try{
            List<Sessoes> sessoes1 = new ArrayList<>();

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Sessoes sessoes = new Sessoes();
                sessoes.setId(resultSet.getInt("id"));
                sessoes.setNomeFilme(resultSet.getString("nomeFilme"));
                sessoes.setHorario(resultSet.getString("horario"));
                sessoes.setNumSala(resultSet.getInt("numSala"));

                sessoes1.add(sessoes);
            }
            resultSet.close();
            preparedStatement.close();
            return sessoes1;
        }
        catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
}

