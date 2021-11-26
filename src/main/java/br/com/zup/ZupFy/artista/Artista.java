package br.com.zup.ZupFy.artista;


import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.gravadora.Gravadora;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

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
  @OneToMany
  private List<Album> albuns;
  @OneToOne
  private Gravadora gravadora;

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

  public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    this.albuns = albuns;
  }

  public Gravadora getGravadora() {
    return gravadora;
  }

  public void setGravadora(Gravadora gravadora) {
    this.gravadora = gravadora;
  }
}
