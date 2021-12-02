package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.enums.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer> {

    List<Artista> findAllByGenero (Genero genero);

    List<Artista> findAllByAnoDeFundacao (String anoDeFundacao);

}
