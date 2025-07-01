package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    //POST manda requisição para cirar
    @PostMapping("/criar")
    public String novaMissao(){
        return "nova missao";
    }

    @GetMapping("/listar")
    public String listarMissoes(){
        return "missoes";
    }
    @GetMapping("listarid")
    public String listarMissaoById(){
        return "Listando por id";
    }
    //PUT manda requisição para alterar
    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "atualizar";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "missao deletada";
    }



}
