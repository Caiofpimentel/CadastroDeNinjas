package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.model;

import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(unique = true)
    private String email;

    @Column(name = "img_Url")
    private String imgUrl;

    private int idade;

    //@ManyToOne Um ninja tem uma unica missão mas a missao pode ter varios ninjas
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign key, Chave estrangeira
    private MissaoModel missoes;
}
