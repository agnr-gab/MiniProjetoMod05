package br.com.zup.ZupFy.artista;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

  @Autowired
  private ArtistaRepository artistaRepository;

}
