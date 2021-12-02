package br.com.zup.ZupFy.album.dtos;

import br.com.zup.ZupFy.gravadora.dtos.GravadoraEntradaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor

public class AlbumEntradaDTO {

  private int id;
  @NotBlank(message = "{validacao.nome.not-blank}")
  @Size(min = 1, max = 255, message = "{validacao.nome.size}")
  private String nome;
  @NotBlank(message = "{validacao.ano.not-blank}")
  @Min(value = 4, message = "{validacao.ano.min}")
  private String ano;
  private GravadoraEntradaDTO gravadora;

}






}
