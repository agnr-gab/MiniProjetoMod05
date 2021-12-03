package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ArtistaResumoDTO {

  private String nome;
  private List<Album> albuns;

}
