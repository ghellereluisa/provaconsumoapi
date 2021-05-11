package com.example.provaapi.Controller;

import com.example.provaapi.DAO.SessoesDAO;
import com.example.provaapi.Model.Sessoes;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class SessoesController {
    private SessoesDAO sessoesDAO = new SessoesDAO();

    @GET
    @Path("criaTabelaSessoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response criaTabelaSessoes(){
        SessoesDAO sessoesDAO = new SessoesDAO();
        sessoesDAO.criarTabela();
        return Response.ok(new Gson().toJson("tabela sessoes criada")).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adcSessoes(Sessoes sessoes){
        try{
            sessoesDAO.inserir(sessoes);
            return Response.status(Response.Status.CREATED).entity(sessoes).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSessoes(){
        List<Sessoes> sessoes = sessoesDAO.buscarSessoes();
        return Response.ok(new Gson().toJson(sessoes)).build();
    }

}
