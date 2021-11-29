package br.com.zup.ZupFy.gravadora;


import br.com.zup.ZupFy.album.Album;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gravadoras")
public class Gravadora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nome;
  /*@OneToMany
  private List<Album> albuns;*/

  public Gravadora() {

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

  /*public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    this.albuns = albuns;
  }*/
}
