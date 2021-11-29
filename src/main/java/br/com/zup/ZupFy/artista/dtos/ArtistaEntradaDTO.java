package br.com.zup.ZupFy.artista.dtos;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.enums.Generos;

import java.util.List;

public class ArtistaEntradaDTO {

  private String nome;
  private Generos genero;
  private String anoDeFundacao;
  private List<Album> albuns;

  public ArtistaEntradaDTO() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Generos getGenero() {
    return genero;
  }

  public void setGenero(Generos genero) {
    this.genero = genero;
  }

  public String getAnoDeFundacao() {
    return anoDeFundacao;
  }

  public void setAnoDeFundacao(String anoDeFundacao) {
    this.anoDeFundacao = anoDeFundacao;
  }

  public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    this.albuns = albuns;
  }

}
