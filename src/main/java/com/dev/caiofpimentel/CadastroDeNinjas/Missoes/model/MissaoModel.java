package com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model;

import com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //@OneToMany uma missão tem varios ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
