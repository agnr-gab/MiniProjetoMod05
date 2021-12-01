package br.com.zup.ZupFy.gravadora;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GravadoraRepository extends CrudRepository<Gravadora, Integer> {

    Optional<Gravadora> findByNome(String nome);

}
