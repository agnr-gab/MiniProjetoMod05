package br.com.zup.ZupFy.artista;

import br.com.zup.ZupFy.artista.dtos.ArtistaEntradaDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaResumoDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaSaidaDTO;
import br.com.zup.ZupFy.enums.Genero;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/artistas")
@Api(value = "Gerenciador de contas")
@CrossOrigin(origins = "*")
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
  @ApiOperation(value = "Método que permite cadastrar artistas")
  public ArtistaEntradaDTO cadastrarArtista(@RequestBody @Valid ArtistaEntradaDTO artistaEntradaDTO) {
    Artista artista = modelMapper.map(artistaEntradaDTO, Artista.class);
    return modelMapper.map(artistaService.cadastrarArtista(artista), ArtistaEntradaDTO.class);

  }

  @GetMapping
  @ApiOperation(value = "Método que permite pesquisar lista de artistas passando parâmetros ou não")
  public List<ArtistaSaidaDTO> exibirArtistas(@RequestParam(required = false) Genero genero,
                                              @RequestParam(required = false) String anoDeFundacao) {
    List<ArtistaSaidaDTO> listaDeArtistas = new ArrayList<>();
    for (Artista artista : artistaService.aplicarFiltro(genero, anoDeFundacao)) {
      ArtistaSaidaDTO artistaSaidaDTO = modelMapper.map(artista, ArtistaSaidaDTO.class);
      listaDeArtistas.add(artistaSaidaDTO);
    }
    return listaDeArtistas;
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Método que permite pesquisar álbuns de um atista específico")
  public ArtistaResumoDTO pesquisarAlbunsPorIdArtista(@PathVariable Integer id) {
    Artista artista = artistaService.buscarPorId(id);
    ArtistaResumoDTO conversao = modelMapper.map(artista, ArtistaResumoDTO.class);
    return conversao;

  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Método que permite deletar um artista a partir de seu id")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarArtista(@PathVariable Integer id) {
    artistaService.deletarArtista(id);
  }

}