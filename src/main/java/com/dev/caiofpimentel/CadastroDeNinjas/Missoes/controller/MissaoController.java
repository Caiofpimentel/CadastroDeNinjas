package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.controller;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    @Autowired
    MissaoService missaoService;

    //POST manda requisição para cirar
    @PostMapping("/criar")
    public MissaoModel novaMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return missaoService.listarMissoes();
    }


    @GetMapping("listar/{id}")
    public Optional<MissaoModel> listarMissaoById(@PathVariable Long id){
        return missaoService.findMissaoId(id);
    }


    //PUT manda requisição para alterar
    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "atualizar";
    }


    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarId(id);

    }



}
