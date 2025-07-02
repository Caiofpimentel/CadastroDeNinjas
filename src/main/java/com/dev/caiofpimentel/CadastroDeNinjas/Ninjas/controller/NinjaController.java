package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.controller;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @Autowired
    private NinjaService ninjaService;

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
      return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public Optional<NinjaModel> listarPorId(@PathVariable Long id){
       return ninjaService.listarNinjaPorId(id);
    }

    //Alterar dado dos ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
      return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }


    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }







}
