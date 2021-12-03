package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.album.AlbumRepository;
import br.com.zup.ZupFy.enums.Genero;
import br.com.zup.ZupFy.exceptions.CadastroExistenteException;
import br.com.zup.ZupFy.exceptions.IdNaoEncontradoException;
import br.com.zup.ZupFy.gravadora.Gravadora;
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
      throw new CadastroExistenteException("Cadastro já existente");
    }
    List<Album> albuns = artista.getAlbuns();
    for (Album album : albuns) {
      Optional<Gravadora> optionalGravadora = gravadoraRepository.findByNome(album.getGravadora().getNome());
      if (optionalGravadora.isPresent()) {
        artista.getAlbuns().get(album.getId()).setGravadora(optionalGravadora.get());
      }

    }

    return artistaRepository.save(artista);

  }

  public List<Artista> exibirListaArtistas() {
    List<Artista> listaDeArtistas = (List<Artista>) artistaRepository.findAll();
    return listaDeArtistas;
  }

  public Artista buscarPorId(Integer id) {
    Optional<Artista> artista = artistaRepository.findById(id);
    if (artista.isPresent()) {
      return artista.get();
    }
    throw new IdNaoEncontradoException("Id não encontrado");
  }

  public void deletarArtista(Integer id) {
    if (artistaRepository.existsById(id)) {
      artistaRepository.deleteById(id);
    } else {
      throw new IdNaoEncontradoException("Id não encontrado");
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