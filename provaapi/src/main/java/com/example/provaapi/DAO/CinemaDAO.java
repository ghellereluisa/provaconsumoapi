package com.example.provaapi.DAO;

import com.example.provaapi.Factory.ConnectionFactory;
import com.example.provaapi.Model.Cinema;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {
    private Connection con;
    String sql;

    public CinemaDAO(){
        this.con = new ConnectionFactory().getConexao();
        PreparedStatement stmt = null;

    }

    public void criarTabela(){
        sql = "create table if not exists Cinema(" +
                "id int not null primary key auto_increment," +
                "nomeCinema varchar(30)," +
                "localCinema varchar(30)," +
                "valorCinema double";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    public void addCinema(Cinema cinema){
        sql = "insert into Cinema(nomeCinema, localCinema, valorCinema)" +
                "values(?, ?, ?)";

        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cinema.getNomeCinema());
            preparedStatement.setString(2, cinema.getLocalCinema());
            preparedStatement.setFloat(3, cinema.getValorCinema());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                int idCinema = resultSet.getInt(1);
                cinema.setId(idCinema);
            }
            preparedStatement.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public List<Cinema> getCinemas(){
        sql = "select * from Cinema";

        try {
            List<Cinema> cinemas = new ArrayList<>();

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Cinema cinema = new Cinema();
                cinema.setId(resultSet.getInt("id"));
                cinema.setNomeCinema(resultSet.getString("nomeCinema"));
                cinema.setLocalCinema(resultSet.getString("localCinema"));
                cinema.setValorCinema(resultSet.getFloat("valorCinema"));
                cinemas.add(cinema);
            }
            resultSet.close();
            preparedStatement.close();
            return cinemas;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}