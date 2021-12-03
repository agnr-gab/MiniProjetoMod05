package br.com.zup.ZupFy.album.dtos;

import br.com.zup.ZupFy.gravadora.dtos.GravadoraEntradaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor

public class AlbumEntradaDTO {

  private int id;
  @NotBlank(message = "Campo não pode estar em branco")
  @Size(min = 1, message = "O Campo dever ter pelo menos 1 caractere")
  private String nome;
  @NotBlank(message = "Campo não pode estar em branco")
  @Min(value = 4, message = "O Campo dever ter pelo menos 4 caracteres")
  private String ano;
  @Valid
  private GravadoraEntradaDTO gravadora;

}