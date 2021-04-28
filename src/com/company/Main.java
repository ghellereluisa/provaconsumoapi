package com.company;
import com.company.model.Cinema;
import com.company.DAO.cinemaDAO;

public class Main {

    public static void main(String[] args) {
	    cinemaDAO cinemadao = new cinemaDAO();
	    cinemadao.criarTabela();


    }
}
