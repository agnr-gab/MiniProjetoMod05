package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.album.AlbumRepository;
import br.com.zup.ZupFy.enums.Genero;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

  public Artista cadastrarArtista(Artista artista) {
    Optional<Artista> optionalArtista = artistaRepository.findById(artista.getId());
    if (optionalArtista.isPresent()) {
      throw new RuntimeException();

    }

    return artistaRepository.save(artista);
  }

  public List<Artista> exibirListaArtistas() {
    List<Artista> listaDeArtistas = (List<Artista>) artistaRepository.findAll();
    return listaDeArtistas;
  }

  public Artista buscarPorId(Integer id) {
    Optional<Artista> artista = artistaRepository.findById(id);
    //TODO: fazer a exceção
    if (artista.isPresent()) {

    }
    return artista.get();
  }

  public void deletarArtista(int id) {
    if (artistaRepository.existsById(id)) {
      artistaRepository.deleteById(id);
    } else {
      throw new RuntimeException();
    }

  }

  public List<Artista> aplicarFiltro(Genero genero, String anoDeFundacao) {
    if (genero != null) {
      return artistaRepository.findAllByGenero(genero);
    } else if (anoDeFundacao != null) {
      return artistaRepository.findAllByAnoDeFundacao(anoDeFundacao);
    }
    return exibirListaArtistas();
  }

}