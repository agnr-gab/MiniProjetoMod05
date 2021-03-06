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

  public Gravadora buscarGravadoraPorId(Integer id) {
    Optional<Gravadora> album = gravadoraRepository.findById(id);
    if (album.isPresent()) {
      return album.get();
    }
    throw new IdNaoEncontradoException("Id não encontrado");
  }


  public Album atualizarAlbum(Integer id, AlbumEntradaDTO albumEntradaDTO) {
    Album albumNovo = buscarAlbumPorId(id);
    albumNovo.setNome(albumEntradaDTO.getNome());
    albumNovo.setAno(albumEntradaDTO.getAno());

    Gravadora gravadora = buscarGravadoraPorId(albumEntradaDTO.getGravadora().getId());
    albumNovo.setGravadora(gravadora);
    albumRepository.save(albumNovo);
    return albumNovo;

  }


  public Album salvarAlbum(Album album) {
    albumRepository.save(album);
    return album;
  }

  public Album cadastrarAlbum(Album album, Integer idArtista) {
    Optional<Artista> optionalArtista = artistaRepository.findById(idArtista);
    Optional<Gravadora> optionalGravadora = gravadoraRepository.findByNome(album.getGravadora().getNome());

    if (optionalArtista.isEmpty()) {
      throw new IdNaoEncontradoException("Id não encontrado");
    }

    if (optionalGravadora.isPresent()) {
      Gravadora gravadora = optionalGravadora.get();
      album.setGravadora(gravadora);

    }

    Artista artista = optionalArtista.get();
    artista.getAlbuns().add(salvarAlbum(album));
    artistaRepository.save(artista);
    return album;
  }

}