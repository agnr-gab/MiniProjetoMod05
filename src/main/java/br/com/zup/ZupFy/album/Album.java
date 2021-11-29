package br.com.zup.ZupFy.album;

import br.com.zup.ZupFy.gravadora.Gravadora;

import javax.persistence.*;

@Entity
@Table(name = "albuns")
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false, unique = true)
  private String nome;
  @Column(nullable = false)
  private String ano;
  @ManyToOne
  private Gravadora gravadora;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Gravadora getGravadora() {
    return gravadora;
  }

  public void setGravadora(Gravadora gravadora) {
    this.gravadora = gravadora;
  }
}
