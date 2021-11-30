package br.com.zup.ZupFy.album;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

    boolean existsByNome(String nome);

    Album findByNome(String nome);

}
