package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ArtistaEntradaDTO {

    @NotBlank(message = "Campo não pode estar em branco")
    @Size(min = 1, message = "O Campo dever ter pelo menos 1 caractere")
    private String nome;
    @NotNull(message = "Campo não pode ser nulo")
    @Valid
    private Genero genero;
    @NotBlank(message = "Campo não pode estar em branco")
    @Min(value = 4, message = "O Campo dever ter pelo menos 1 caractere")
    private String anoDeFundacao;
    @Valid
    private List<Album> albuns;

}