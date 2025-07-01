package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.repository;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {

}
