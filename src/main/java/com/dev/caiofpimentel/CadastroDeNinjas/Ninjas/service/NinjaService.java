package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service;


import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

   private final NinjaRepository ninjaRepository;
   private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Criar Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
       ninja = ninjaRepository.save(ninja);
       return ninjaMapper.map(ninja);
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
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){

      if (ninjaRepository.existsById(id)){
          ninjaAtualizado.setId(id);
          return ninjaRepository.save(ninjaAtualizado);
      }else {
          return null;
      }




    }

    //Deletar Ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }






}
