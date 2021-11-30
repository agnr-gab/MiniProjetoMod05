package br.com.zup.ZupFy.artista;


import br.com.zup.ZupFy.artista.dtos.ArtistaEntradaDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

  @Autowired
  private ArtistaService artistaService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ArtistaEntradaDTO cadastrarArtista(@RequestBody ArtistaEntradaDTO artistaEntradaDTO) {
    Artista artista = modelMapper.map(artistaEntradaDTO, Artista.class);
    return modelMapper.map(artistaService.verificarArtista(artista), ArtistaEntradaDTO.class);

  }

  @GetMapping
  public List<ArtistaSaidaDTO> exibirArtista() {
    List<ArtistaSaidaDTO> listaDeArtistas = new ArrayList<>();
    for (Artista artista : artistaService.exibirLista()) {
      ArtistaSaidaDTO artistaSaidaDTO = modelMapper.map(artista, ArtistaSaidaDTO.class);
      listaDeArtistas.add(artistaSaidaDTO);
    }
    return listaDeArtistas;
  }

}
