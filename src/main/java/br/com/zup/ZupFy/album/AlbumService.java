package br.com.zup.ZupFy.album;


import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import br.com.zup.ZupFy.artista.Artista;
import br.com.zup.ZupFy.artista.ArtistaRepository;
import br.com.zup.ZupFy.gravadora.Gravadora;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

  @Autowired
  private AlbumRepository albumRepository;
  @Autowired
  private ArtistaRepository artistaRepository;
  @Autowired
  private GravadoraRepository gravadoraRepository;


  public Album buscarPorId(Integer id) {
    Optional<Album> album = albumRepository.findById(id);
    //TODO: fazer a exceção
    if (album.isPresent()) {

    }
    return album.get();
  }

  public Album atualizarListaAlbum(Integer id, AlbumEntradaDTO albumEntradaDTO) {
    Album albumNovo = buscarPorId(id);
    albumNovo.setNome(albumEntradaDTO.getNome());
    albumNovo.setAno(albumEntradaDTO.getAno());
    Gravadora gravadora = gravadoraRepository.findById(albumEntradaDTO.getGravadora().getId()).get();
    albumNovo.setGravadora(gravadora);
    albumRepository.save(albumNovo);
    return albumNovo;
  }

  public Album salvarAlbum(Album album) {
    albumRepository.save(album);
    return album;
  }

  /*public Album verificarAlbum(Album album) {
    if (albumRepository.existsById(album.getId())) {
      throw new RuntimeException();
    }
    return salvarAlbum(album);
  }*/

  public Album cadastrarAlbum(Album album, int idArtista) {
    Optional<Artista> optionalArtista = artistaRepository.findById(idArtista);
    Optional<Gravadora> optionalGravadora = gravadoraRepository.findByNome(album.getGravadora().getNome());

    if (optionalArtista.isEmpty() || optionalGravadora.isEmpty()) {
      throw new RuntimeException();
    }

    Artista artista = optionalArtista.get();
    Gravadora gravadora = optionalGravadora.get();
    album.setGravadora(gravadora);
    artista.getAlbuns().add(salvarAlbum(album));
    artistaRepository.save(artista);
    return album;

  }

}
