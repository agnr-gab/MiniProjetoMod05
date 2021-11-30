package br.com.zup.ZupFy.artista;


import br.com.zup.ZupFy.album.Album;
import br.com.zup.ZupFy.album.AlbumRepository;
import br.com.zup.ZupFy.album.dtos.AlbumEntradaDTO;
import br.com.zup.ZupFy.gravadora.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    private ArtistaRepository artistaRepository;
    private GravadoraRepository gravadoraRepository;
    private AlbumRepository albumRepository;


    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository, GravadoraRepository gravadoraRepository,
                          AlbumRepository albumRepository) {
        this.artistaRepository = artistaRepository;
        this.gravadoraRepository = gravadoraRepository;
        this.albumRepository = albumRepository;
    }

    public Artista salvarArtista(Artista artista) {
        artistaRepository.save(artista);
        return artista;
    }

    public Artista verificarArtista(Artista artista) {
        if (artistaRepository.existsByNome(artista.getNome())) {
            throw new RuntimeException();

        }
        return salvarArtista(artista);
    }

    public List<Artista> exibirLista() {
        List<Artista> listaDeArtistas = (List<Artista>) artistaRepository.findAll();
        return listaDeArtistas;
    }

    public List<Artista> buscarPorNome(String nome) {
        return artistaRepository.findAllByNome(nome);

    }

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

}
