package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.controller;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
      NinjaDTO novoNInja =  ninjaService.criarNinja(ninja);
      return ResponseEntity.status(HttpStatus.CREATED)
              .body("Ninja Criado Com Sucesso: " + novoNInja.getNome() + " (ID): " + novoNInja.getId());
    }


    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
       Optional<NinjaDTO> ninja = ninjaService.listarNinjaPorId(id);
       if (ninja.isPresent()){
           return ResponseEntity.ok(ninja);
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado com id: "+ id);
       }


    }

    //Alterar dado dos ninjas (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado, ID: "+id);
        }
    }


    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){

        if (ninjaService.listarNinjaPorId(id).isPresent()){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com id:" + id +" deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id:" + id + " não encontrado!");
        }



    }







}
