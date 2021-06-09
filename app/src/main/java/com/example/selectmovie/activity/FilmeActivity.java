package com.example.selectmovie.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.selectmovie.R;
import com.example.selectmovie.model.Filme;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class FilmeActivity extends AppCompatActivity {
    private Filme filmes;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        Intent  intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        filmes = (Filme) bundle.getSerializable("filme");

        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(filmes.getRatingBar());

        TextView sinopse = findViewById(R.id.text_sinopse);
        sinopse.setText(filmes.getSinopse());
        TextView tituloSinopse = findViewById(R.id.text_titulo_sinopse);
        tituloSinopse.setText(filmes.getTituloSinopse());




        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);



        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo(filmes.getIdyt(), 0);
            }
        });

    }
}