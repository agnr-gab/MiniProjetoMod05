package br.com.zup.ZupFy.album;

import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

    private AlbumService albumService;
    private ModelMapper modelMapper;

    @Autowired
    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumEntradaDTO cadastrarAlbum(@RequestBody @Valid AlbumEntradaDTO albumEntradaDTO,
                                          @RequestParam Integer idArtista) {
        Album album = modelMapper.map(albumEntradaDTO, Album.class);
        album = albumService.cadastrarAlbum(album, idArtista);
        return modelMapper.map(album, AlbumEntradaDTO.class);
    }

    @PutMapping("/{id}")
    public AlbumEntradaDTO atualizarAlbuns(@PathVariable Integer id,
                                           @RequestBody @Valid AlbumEntradaDTO albumEntradaDTO) {
        return modelMapper.map(albumService.atualizarAlbum(id, albumEntradaDTO), AlbumEntradaDTO.class);
    }

}