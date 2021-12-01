package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;

import java.util.List;

public class ArtistaResumoDTO {
  private String nome;
  private List <Album> albuns;

  public ArtistaResumoDTO() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    this.albuns = albuns;
  }

}
