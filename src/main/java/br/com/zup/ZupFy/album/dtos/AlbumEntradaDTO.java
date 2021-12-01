package br.com.zup.ZupFy.album.dtos;

import br.com.zup.ZupFy.gravadora.dtos.GravadoraEntradaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AlbumEntradaDTO {

    private int id;
    private String nome;
    private String ano;
    private GravadoraEntradaDTO gravadoraEntradaDTO;

}

