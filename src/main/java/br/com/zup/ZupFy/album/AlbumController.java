package br.com.zup.ZupFy.album;

import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

  @Autowired
  private AlbumService albumService;

  @Autowired
  private ModelMapper modelMapper;

  @PutMapping("/{id}")
  public AlbumEntradaDTO atualizarListaAlbuns(@PathVariable Integer id,
                                              @RequestBody AlbumEntradaDTO albumEntradaDTO) {
    return modelMapper.map(albumService.atualizarListaAlbum(id, albumEntradaDTO), AlbumEntradaDTO.class);
  }

}
