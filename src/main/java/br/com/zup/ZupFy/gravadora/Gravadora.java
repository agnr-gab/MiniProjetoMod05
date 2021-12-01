package br.com.zup.ZupFy.gravadora;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gravadoras")
@Getter
@Setter
@NoArgsConstructor

public class Gravadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

}
