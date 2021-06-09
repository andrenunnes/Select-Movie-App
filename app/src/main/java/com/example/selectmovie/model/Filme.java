package com.example.selectmovie.model;

import android.widget.RatingBar;

import java.io.Serializable;

public class Filme implements Serializable {
    private String titulo;
    private String classificacao;
    private String data;
    private String plataforma;
    private String genero;
    private String imagem;
    private String idyt;
    private String sinopse;
    private String tituloSinopse;
    private Float ratingBar;


    public Filme(){

    }

    public Filme(String titulo, String classificacao, String data, String plataforma, String genero, String imagem, String idyt, String sinopse, String tituloSinopse, Float ratingBar) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.data = data;
        this.plataforma = plataforma;
        this.genero = genero;
        this.imagem = imagem;
        this.idyt = idyt;
        this.sinopse = sinopse;
        this.tituloSinopse = tituloSinopse;
        this.ratingBar = ratingBar;

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

    public String getIdyt() {
        return idyt;
    }

    public void setIdyt(String idyt) {
        this.idyt = idyt;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTituloSinopse() {
        return tituloSinopse;
    }

    public void setTituloSinopse(String tituloSinopse) {
        this.tituloSinopse = tituloSinopse;
    }


    public Float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(Float ratingBar) {
        this.ratingBar = ratingBar;
    }
}
