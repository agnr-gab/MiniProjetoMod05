package br.com.zup.ZupFy.album;

import javax.persistence.*;

@Entity
@Table(name = "albuns")
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String ano;

  public Album() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }
}
