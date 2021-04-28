package com.company.DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.company.Factory.connectionFactory;
import com.company.model.Cinema;

public class cinemaDAO {
    private Connection con;

    public cinemaDAO(){
        this.con = new connectionFactory().getConexao();
        PreparedStatement stmt = null;

    }

    public void criarTabela(){
        String sql = "create table if not exists Cinema(" +
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
            public void inserir(Cinema cinema){
                String sql = "insert into cinema values(?, ?, ?)";

                try{
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, cinema.getNomeCinema());
                    stmt.setString(2, cinema.getLocalCinema());
                    stmt.setFloat(3, cinema.getValorCinema());

                    stmt.executeUpdate();
                    stmt.close();
                }
                catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }
}
