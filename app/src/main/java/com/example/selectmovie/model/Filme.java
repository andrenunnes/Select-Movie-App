package com.example.selectmovie.model;

public class Filme {
    private String titulo;
    private String classificacao;
    private String data;
    private String plataforma;
    private String genero;
    private String imagem;


    public Filme(){

    }

    public Filme(String titulo, String classificacao, String data, String plataforma, String genero, String imagem) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.data = data;
        this.plataforma = plataforma;
        this.genero = genero;
        this.imagem = imagem;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
