package br.com.zup.ZupFy.artista;


import br.com.zup.ZupFy.album.AlbumRepository;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistaService {
  private ArtistaRepository artistaRepository;
  private GravadoraRepository gravadoraRepository;
  private AlbumRepository albumRepository;


  @Autowired
  public ArtistaService(ArtistaRepository artistaRepository, GravadoraRepository gravadoraRepository,
                        AlbumRepository albumRepository) {
    this.artistaRepository = artistaRepository;
    this.gravadoraRepository = gravadoraRepository;
    this.albumRepository = albumRepository;
  }

  public Artista cadastrarArtista (Artista artista) {
    artistaRepository.save(artista);
    return artista;
  }

  public Artista verificarArtista (Artista artista) {
    Optional<Artista> nomeArtista = artistaRepository.findAllByNome(artista.getNome())
  }

}
