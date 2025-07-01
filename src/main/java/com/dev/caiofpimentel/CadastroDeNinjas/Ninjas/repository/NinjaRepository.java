package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.repository;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
