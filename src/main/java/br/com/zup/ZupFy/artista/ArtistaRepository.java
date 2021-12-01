package br.com.zup.ZupFy.artista;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer> {

    boolean existsByNome(String nome);

    List<Artista> findAllByNome(String nome);


}
