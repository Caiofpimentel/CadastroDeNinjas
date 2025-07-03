package com.dev.caiofpimentel.CadastroDeNinjas.Ninjas.DTO;


import com.dev.caiofpimentel.CadastroDeNinjas.Missoes.model.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private MissaoModel missoes;

}
