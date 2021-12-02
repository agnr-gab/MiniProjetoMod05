package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artistas")
@Getter
@Setter
@NoArgsConstructor

public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(nullable = false)
    private String anoDeFundacao;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Album> albuns;

}