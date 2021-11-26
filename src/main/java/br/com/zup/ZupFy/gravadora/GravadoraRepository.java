package br.com.zup.ZupFy.gravadora;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravadoraRepository extends CrudRepository<Gravadora, Integer> {

}
