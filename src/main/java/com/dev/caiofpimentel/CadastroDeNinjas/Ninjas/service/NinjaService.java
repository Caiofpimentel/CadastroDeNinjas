package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

   private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Criar Ninja
    public void criarNinja(String nome, String email, String imgUrl, int idade, MissaoModel missao){

        NinjaModel ninja = new NinjaModel(nome, email,imgUrl,idade,missao );
        ninjaRepository.save(ninja);
    }

    //Listar todos os Ninjas
    public List<NinjaModel> listarNinjas(){

        return ninjaRepository.findAll();

    }

    //Listar um Ninja por Id
    public Optional<NinjaModel> listarNinjaPorId(Long id){

        return ninjaRepository.findById(id);
    }

    //Alterar dados do ninja
    public void atualizarNinja(){



    }

    //Deletar Ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }






}
