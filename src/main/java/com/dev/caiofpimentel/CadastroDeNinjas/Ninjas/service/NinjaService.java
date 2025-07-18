package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.service;


import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

    }

    //Listar um Ninja por Id
    public Optional<NinjaDTO> listarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);

        return ninjaPorId.map(ninjaMapper::map);
    }

    //Alterar dados do ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninja = ninjaExistente.get();
            // Atualizar campos manualmente para não perder outros dados
            ninja.setNome(ninjaDTO.getNome());
            ninja.setEmail(ninjaDTO.getEmail());
            ninja.setImgUrl(ninjaDTO.getImgUrl());
            ninja.setIdade(ninjaDTO.getIdade());
            ninja.setRank(ninjaDTO.getRank());

            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


    //Deletar Ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }






}
