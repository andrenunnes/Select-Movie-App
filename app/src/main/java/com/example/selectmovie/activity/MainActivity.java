package com.example.selectmovie.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.selectmovie.R;
import com.example.selectmovie.adapter.FilmeAdapter;
import com.example.selectmovie.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;
    private List<Filme> filmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFilmes = findViewById(R.id.recyclerFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerFilmes.setLayoutManager(layoutManager);

        this.prepararFIlmes();
        FilmeAdapter filmeAdapter = new FilmeAdapter(filmes, getApplicationContext());
        recyclerFilmes.setAdapter(filmeAdapter);
    }

    public void prepararFIlmes(){

        this.filmes.add(new Filme("Tropa de Elite", "Classificação: 16", "Ano de Lançamento: 2007", "Plataforma: Netflix/Telecine/Youtube", "Gênero: Crime/Ação", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR49CYQ7XWOfxWvS7oEfnyzrtA4l4y9AqB7XYdvIr3SwhRfEv4y" ));
        this.filmes.add(new Filme("Harry Potter e o Prisioneiro de Azkaban", "Classificação: Livre", "Ano de Lançamento: 2004", "Plataforma: Youtube", "Gênero: Fantasia/Aventura", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVRAOegxdFc-cTszFJiY2CD-yi96VTXhhdmQxY5Td36LJkKTgm" ));
        this.filmes.add(new Filme("Projeto X", "Classificação: 18", "Ano de Lançamento: 2012", "Plataforma: Youtube", "Gênero: Comédia", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSFT3GI7hLPLjKASsiSN980quFdMCxg3VaYvntzgmxE4Avps6Ep"));
        this.filmes.add(new Filme("O Labirinto do Fauno", "Classificação: 16", "Ano de Lançamento: 2006", "Plataforma: Youtube", "Gênero: Fantasia/Guerra", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ_Y6-P9En2c4f2EIpgpp5FPfiZo0iMimQLV3Rcwu3_PRAF61xe"));
        this.filmes.add(new Filme("O Protetor", "Classificação: 16", "Ano de Lançamento: 2014", "Plataforma: Netflix/Youtube", "Gênero: Ação/Thriller", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0yf8JOQ3bI4fzvs8n6sBkslIDnlpdpH9uv5d7AOWo8h973jP1"));
        this.filmes.add(new Filme("Shrek", "Classificação: Livre", "Ano de Lançamento: 2001", "Plataforma: Netflix/Youtube/Prime Video/Telecine", "Gênero: Comédia/Fantasia", "https://upload.wikimedia.org/wikipedia/pt/e/e6/Shrek_Poster.jpg"));
        this.filmes.add(new Filme("Sniper Americano", "Classificação: 16", "Ano de Lançamento: 2014", "Plataforma: Netflix/Youtube", "Gênero: Guerra/Ação", "https://moviesense.files.wordpress.com/2020/03/8d583-americansniper1.jpg"));

    }
}