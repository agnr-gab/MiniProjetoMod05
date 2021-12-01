package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.enums.Generos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ArtistaEntradaDTO {

    private String nome;
    private Generos genero;
    private String anoDeFundacao;
    private List<Album> albuns;

}