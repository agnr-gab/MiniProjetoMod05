package br.com.zup.ZupFy.artista;


import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.album.AlbumRepository;
import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaEntradaDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaResumoDTO;
import br.com.zup.ZupFy.artista.dtos.ArtistaSaidaDTO;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    return modelMapper.map(artistaService.cadastrarArtista(artista), ArtistaEntradaDTO.class);

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

  @GetMapping("/{id}")
  public ArtistaResumoDTO pesquisarAlbunsPorArtista(@PathVariable Integer id) {
    Artista artista = artistaService.buscarPorId(id);
    ArtistaResumoDTO conversao = modelMapper.map(artista, ArtistaResumoDTO.class);
    return conversao;

}
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarConta(@PathVariable int id) {
    artistaService.deletarArtista(id);
  }

}

