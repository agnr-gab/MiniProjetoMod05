package br.com.zup.ZupFy.artista;


import javax.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String genero;
  @Column(nullable = false)
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
