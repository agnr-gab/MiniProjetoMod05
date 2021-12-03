package br.com.zup.ZupFy.album;

import br.com.zup.ZupFy.gravadora.Gravadora;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "albuns")
@Getter
@Setter
@NoArgsConstructor
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false, unique = true)
  private String nome;
  @Column(nullable = false, name = "ano")
  private String ano;
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private Gravadora gravadora;

}
