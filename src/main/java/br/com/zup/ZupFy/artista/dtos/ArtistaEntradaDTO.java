package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ArtistaEntradaDTO {

    @NotBlank(message = "{validacao.nome.not-blank}")
    @Size(min = 1, max = 255, message = "{validacao.nome.size}")
    private String nome;
    @NotNull(message = "{validacao.genero.not-null}")
    private Genero genero;
    @NotBlank(message = "{validacao.anoDeFundacao.not-blank}")
    @Min(value = 4, message = "{validacao.anoDeFundacao.min}")
    private String anoDeFundacao;
    private List<Album> albuns;

}