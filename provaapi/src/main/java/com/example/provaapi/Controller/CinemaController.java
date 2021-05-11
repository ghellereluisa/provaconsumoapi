package com.example.provaapi.Controller;

import com.example.provaapi.DAO.CinemaDAO;
import com.example.provaapi.Model.Cinema;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class CinemaController {
    private CinemaDAO cinemaDAO = new CinemaDAO();

    @GET
    @Path("criaTabelaCinema")
    @Produces(MediaType.APPLICATION_JSON)
    public Response criaTabelaCinema(){
        CinemaDAO cinemaDAO = new CinemaDAO();
        cinemaDAO.criarTabela();
        return Response.ok(new Gson().toJson("tabela cinema criada")).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adcCinema(Cinema cinema){
        try{
            cinemaDAO.addCinema(cinema);
            return Response.status(Response.Status.CREATED).entity(cinema).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCinema(){
        List<Cinema> cinema = cinemaDAO.getCinemas();
        return Response.ok(new Gson().toJson(cinema)).build();
    }
}
