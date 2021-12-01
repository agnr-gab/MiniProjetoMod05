package br.com.zup.ZupFy.album.dtos;

import br.com.zup.ZupFy.gravadora.Gravadora;

public class AlbumEntradaDTO {

    private int id;
    private String nome;
    private String ano;
    private Gravadora gravadora; //usar uma DTO de entrada somente com o ID

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

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

}

