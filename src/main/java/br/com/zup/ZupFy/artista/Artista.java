package br.com.zup.ZupFy.artista;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {

  private int id;
  private String nome;
  private String genero;
  private String anoDeFundacao;

  public Artista() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getAnoDeFundacao() {
    return anoDeFundacao;
  }

  public void setAnoDeFundacao(String anoDeFundacao) {
    this.anoDeFundacao = anoDeFundacao;
  }

}
