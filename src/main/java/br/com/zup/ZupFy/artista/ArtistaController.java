package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.artista.dtos.ArtistaEntradaDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaResumoDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaSaidaDTO;
import br.com.zup.ZupFy.enums.Genero;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

  private ArtistaService artistaService;
  private ModelMapper modelMapper;

  @Autowired
  public ArtistaController(ArtistaService artistaService, ModelMapper modelMapper) {
    this.artistaService = artistaService;
    this.modelMapper = modelMapper;

  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ArtistaEntradaDTO cadastrarArtista(@RequestBody ArtistaEntradaDTO artistaEntradaDTO) {
    Artista artista = modelMapper.map(artistaEntradaDTO, Artista.class);
    return modelMapper.map(artistaService.cadastrarArtista(artista), ArtistaEntradaDTO.class);

  }

  @GetMapping
  public List<ArtistaSaidaDTO> exibirArtistas(@RequestParam(required = false) Genero genero,
                                              @RequestParam (required = false) String anoDeFundacao) {
    List<ArtistaSaidaDTO> listaDeArtistas = new ArrayList<>();
    for (Artista artista : artistaService.aplicarFiltro(genero, anoDeFundacao)) {
      ArtistaSaidaDTO artistaSaidaDTO = modelMapper.map(artista, ArtistaSaidaDTO.class);
      listaDeArtistas.add(artistaSaidaDTO);
    }
    return listaDeArtistas;
  }

  @GetMapping("/{id}")
  public ArtistaResumoDTO pesquisarAlbunsPorIdArtista(@PathVariable Integer id) {
    Artista artista = artistaService.buscarPorId(id);
    ArtistaResumoDTO conversao = modelMapper.map(artista, ArtistaResumoDTO.class);
    return conversao;

  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarArtista(@PathVariable int id) {
    artistaService.deletarArtista(id);
  }

}