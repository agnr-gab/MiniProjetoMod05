package br.com.zup.ZupFy.artista;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

  @Autowired
  private ArtistaService artistaService;

  @Autowired
  private ModelMapper modelMapper;

}
