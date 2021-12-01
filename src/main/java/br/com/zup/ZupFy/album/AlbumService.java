package br.com.zup.ZupFy.album;


import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

  @Autowired
  private AlbumRepository albumRepository;


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
    albumNovo.setGravadora(albumEntradaDTO.getGravadora());
    albumRepository.save(albumNovo);
    return albumNovo;
  }

  public Album salvarAlbum (Album album){
    albumRepository.save(album);
    return album;
  }

  public Album verificarAlbum(Album album){
    if (albumRepository.existsById(album.getId())){
      throw new RuntimeException();
    }
    return salvarAlbum(album);
  }

}
