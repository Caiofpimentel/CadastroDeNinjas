package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.service;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.repository.MissaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //criar
    public MissaoModel criarMissao(MissaoModel missao){
      return missaoRepository.save(missao);
    }

    //listar
    public List<MissaoModel> listarMissoes(){
     return missaoRepository.findAll();
    }


    //listarid
    public Optional<MissaoModel> findMissaoId(Long id){
      return missaoRepository.findById(id);
    }

    //atualizar



    //deletar
    public void deletarId(Long id){
        missaoRepository.deleteById(id);
    }


}
