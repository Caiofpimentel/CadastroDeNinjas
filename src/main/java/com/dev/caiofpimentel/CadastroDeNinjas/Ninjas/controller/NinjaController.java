package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minhas primeira mensagem nessa rota";
    }


    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/all")
    public String mostrarTodosNinjas(){
        return "Mostrar todos ninjas";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/id")
    public String mostrarNinjaId(){
        return "Mostrar ninja por Id";
    }

    //Alterar dado dos ninjas (UPDATE)
    @PutMapping("/atualizar")
    public String atualizarNinja(){
        return "Atualizando Ninja";
    }


    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinja(){
        return "Ninja deletado por Id";
    }







}
