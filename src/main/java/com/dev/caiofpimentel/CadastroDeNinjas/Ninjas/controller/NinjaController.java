package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(){
        return "Mostrar todos ninjas";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listarid")
    public String mostrarNinjaId(){
        return "Mostrar ninja por Id";
    }

    //Alterar dado dos ninjas (UPDATE)
    @PutMapping("/atualizar")
    public String atualizarNinja(){
        return "Atualizando Ninja";
    }


    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja(){
        return "Ninja deletado por Id";
    }







}
