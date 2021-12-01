package br.com.zup.ZupFy.album.dtos;

import br.com.zup.ZupFy.gravadora.Gravadora;
import br.com.zup.ZupFy.gravadora.dtos.GravadoraEntradaDTO;

public class AlbumEntradaDTO {

    private int id;
    private String nome;
    private String ano;
    private GravadoraEntradaDTO gravadoraEntradaDTO;

    public AlbumEntradaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public GravadoraEntradaDTO getGravadora() {
        return gravadoraEntradaDTO;
    }

    public void setGravadora(GravadoraEntradaDTO gravadora) {
        this.gravadoraEntradaDTO = gravadora;
    }

}

