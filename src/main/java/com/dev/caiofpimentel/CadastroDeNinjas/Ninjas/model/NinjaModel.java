package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity //Entity transforma uma classe em uma entidade no banco de dados.
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private List<MissaoModel> missoes;
}
