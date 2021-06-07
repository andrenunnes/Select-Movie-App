package com.example.selectmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.selectmovie.R;
import com.example.selectmovie.model.Filme;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.MyViewHolder> {

    private List<Filme> filmes;
    private Context context;

    public FilmeAdapter(List<Filme> listafilmes, Context context) {
        this.filmes = listafilmes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.filme_detalhe, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = filmes.get(position);
        holder.texttitulo.setText(filme.getTitulo());
        holder.textclassifcacao.setText(filme.getClassificacao());
        holder.textgenero.setText(filme.getGenero());
        holder.textplataforma.setText(filme.getPlataforma());
        holder.textdata.setText(filme.getData());
        Glide.with(context).load(filme.getImagem()).into(holder.imageFilme);



    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView texttitulo;
        private TextView textdata;
        private ImageView imageFilme;
        private TextView textplataforma;
        private TextView textgenero;
        private TextView textclassifcacao;
        private TextView duracao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            texttitulo = itemView.findViewById(R.id.text_titulo);
            textdata = itemView.findViewById(R.id.text_data);
            textplataforma = itemView.findViewById(R.id.text_plataforma);
            textgenero = itemView.findViewById(R.id.text_genero);
            textclassifcacao = itemView.findViewById(R.id.text_classificacao);
            imageFilme = itemView.findViewById(R.id.image_filme);



        }
    }
}
