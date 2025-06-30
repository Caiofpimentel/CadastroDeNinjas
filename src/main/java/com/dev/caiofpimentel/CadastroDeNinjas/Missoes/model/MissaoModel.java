package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private enum dificuldade{S,A,B,C,D,E};


    private NinjaModel ninja;
}
