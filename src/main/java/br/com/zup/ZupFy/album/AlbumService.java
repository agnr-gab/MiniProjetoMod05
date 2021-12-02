package br.com.zup.ZupFy.album;

import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import br.com.zup.ZupFy.artista.Artista;
import br.com.zup.ZupFy.artista.ArtistaRepository;
import br.com.zup.ZupFy.exceptions.IdNaoEncontradoException;
import br.com.zup.ZupFy.gravadora.Gravadora;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

  private AlbumRepository albumRepository;
  private ArtistaRepository artistaRepository;
  private GravadoraRepository gravadoraRepository;

  @Autowired
  public AlbumService(AlbumRepository albumRepository, ArtistaRepository artistaRepository, GravadoraRepository gravadoraRepository) {
    this.albumRepository = albumRepository;
    this.artistaRepository = artistaRepository;
    this.gravadoraRepository = gravadoraRepository;
  }

  public Album buscarAlbumPorId(Integer id) {
    Optional<Album> album = albumRepository.findById(id);
    if (album.isPresent()) {
      return album.get();
    }
    throw new IdNaoEncontradoException("Id não encontrado");
  }

  public Album atualizarAlbum(Integer id, AlbumEntradaDTO albumEntradaDTO) {
    Album albumNovo = buscarAlbumPorId(id);
    albumNovo.setNome(albumEntradaDTO.getNome());
    albumNovo.setAno(albumEntradaDTO.getAno());
    Optional<Gravadora> optionalGravadora = gravadoraRepository.findById(albumEntradaDTO.getGravadora().getId());
    if (optionalGravadora.isPresent()) {
      Gravadora gravadora = optionalGravadora.get();
      albumNovo.setGravadora(gravadora);
      albumRepository.save(albumNovo);
      return albumNovo;

    }
    throw new RuntimeException();
  }


  public Album salvarAlbum(Album album) {
    albumRepository.save(album);
    return album;
  }

  public Album cadastrarAlbum(Album album, Integer idArtista) {
    Optional<Artista> optionalArtista = artistaRepository.findById(idArtista);
    Optional<Gravadora> optionalGravadora = gravadoraRepository.findByNome(album.getGravadora().getNome());

    if (optionalArtista.isEmpty() || optionalGravadora.isEmpty()) {
      throw new IdNaoEncontradoException("Id não encontrado");
    }

    Artista artista = optionalArtista.get();
    Gravadora gravadora = optionalGravadora.get();
    album.setGravadora(gravadora);
    artista.getAlbuns().add(salvarAlbum(album));
    artistaRepository.save(artista);
    return album;

  }

}
