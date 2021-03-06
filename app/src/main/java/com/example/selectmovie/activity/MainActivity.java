package com.example.selectmovie.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.selectmovie.R;
import com.example.selectmovie.adapter.FilmeAdapter;
import com.example.selectmovie.helper.ConfiguracaoFirebase;
import com.example.selectmovie.helper.RecyclerItemClickListener;
import com.example.selectmovie.model.Filme;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;
    private List<Filme> filmes = new ArrayList<>();
    private FirebaseAuth autenticacao;


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

        recyclerFilmes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerFilmes, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("filme", filmes.get(position));
                Intent intent = new Intent(MainActivity.this, FilmeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        MenuItem item = menu.findItem(R.id.item_Search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSair:
                autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                autenticacao.signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void prepararFIlmes(){

        this.filmes.add(new Filme("Tropa de Elite", "16", "2007", "Netflix/Telecine/Youtube", "Crime/A????o", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR49CYQ7XWOfxWvS7oEfnyzrtA4l4y9AqB7XYdvIr3SwhRfEv4y" ,
                "uZBiNJQxtGw","Nascimento, capit??o da Tropa de Elite do Rio de Janeiro, ?? designado para chefiar uma das equipes que tem como miss??o apaziguar o Morro do Turano. Ele precisa cumprir as ordens enquanto procura por um substituto para ficar em seu lugar. Em meio a um tiroteio, Nascimento e sua equipe resgatam Neto e Matias, dois aspirantes a oficiais da PM. Ansiosos para entrar em a????o e impressionados com a efici??ncia de seus salvadores, os dois se candidatam ao curso de forma????o da Tropa de Elite.","Tropa de Elite", 5f));
        this.filmes.add(new Filme("Harry Potter e o Prisioneiro de Azkaban", "Livre", "2004", "Youtube", "Fantasia/Aventura", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVRAOegxdFc-cTszFJiY2CD-yi96VTXhhdmQxY5Td36LJkKTgm",
                "2fI-PAOsA1I", "O terceiro ano de Harry Potter em Hogwarts come??a mal quando ele descobre que o assassino Sirius Black escapou da pris??o de Azkaban e est?? empenhado em mat??-lo. Enquanto o gato de Hermione atormenta o rato doente de Ron, dementadores s??o enviados para proteger a escola de Sirius Black. Um professor misterioso ajuda Harry a aprender a se defender.", "Harry Potter e o Prisioneiro de Azkaban", 5f));
        this.filmes.add(new Filme("Projeto X", "18", "2012", "Youtube", "Com??dia", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSFT3GI7hLPLjKASsiSN980quFdMCxg3VaYvntzgmxE4Avps6Ep",
                "kFwGmQIe-rU", "Tr??s amigos de col??gio planejam uma festa inesquec??vel que entrar?? para a hist??ria na tentativa de ficarem famosos. A not??cia se espalha rapidamente e tudo foge ao controle quando os imprevistos come??am a acontecer.","Projeto X",4.5f));
        this.filmes.add(new Filme("O Labirinto do Fauno", "16", "2006", "Youtube", "Fantasia/Guerra", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ_Y6-P9En2c4f2EIpgpp5FPfiZo0iMimQLV3Rcwu3_PRAF61xe",
                "dr-lLqOqYGk", "Em 1944, na Espanha, a jovem Of??lia e sua m??e doente chegam ao posto do novo marido de sua m??e, um s??dico oficial do ex??rcito que est?? tentando reprimir uma guerrilheira. Enquanto explorava um labirinto antigo, Of??lia encontra o Pan fauno, que diz que a menina ?? uma lend??ria princesa perdida e que ela precisa completar tr??s tarefas perigosas a fim de se tornar imortal.", "O Labirinto do Fauno",4f));
        this.filmes.add(new Filme("O Protetor", "16", "2014", "Netflix/Youtube", "A????o/Thriller", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0yf8JOQ3bI4fzvs8n6sBkslIDnlpdpH9uv5d7AOWo8h973jP1",
                "SLhhP7iknf8", "O ex-agente secreto Robert McCall acredita que seu passado ficou para tr??s e tenta viver uma nova vida. Ele conhece Alina, uma jovem que est?? sob poder de uma quadrilha russa, e simplesmente n??o consegue ignor??-la. Munido de suas extraordin??rias habilidades, ele ressurge como um verdadeiro anjo vingador. Fora da aposentadoria e com um novo desejo de fazer justi??a, McCall decide ajudar quem foi brutalizado e oprimido.", "O Protetor", 3.5f));
        this.filmes.add(new Filme("Shrek", "Livre", "2001", "Netflix/Youtube/Prime Video/Telecine", "Com??dia/Fantasia", "https://upload.wikimedia.org/wikipedia/pt/e/e6/Shrek_Poster.jpg",
                "seUURVsRCD4", "Era uma vez um p??ntano distante, onde vivia um ogro chamado Shrek. De repente, seu sossego ?? interrompido pela invas??o de personagens de contos de fadas que foram banidos de seu reino pelo maldoso Lorde Farquaad. Determinado a salvar o lar das pobres criaturas, e tamb??m o dele, Shrek faz um acordo com Farquaad e parte para resgatar a princesa Fiona. Resgatar a princesa pode n??o ser nada comparado com seu segredo profundo e sombrio.", "Shrek", 3.5f));
        this.filmes.add(new Filme("Sniper Americano", "16", "2014", "Netflix/Youtube", "Guerra/A????o", "https://moviesense.files.wordpress.com/2020/03/8d583-americansniper1.jpg",
                "Gl2jBtlJ42g", "Hist??ria real de Chris Kyle, atirador de elite das for??as especiais da marinha dos Estados Unidos. Durante a guerra do Iraque, sua miss??o era uma s??- proteger seus companheiros. Seu dever fez dele um dos maiores atiradores da hist??ria americana. Sua precis??o salva in??meras vidas, mas tamb??m o torna um alvo preferencial. Quando Kyle finalmente volta para casa, ele descobre que n??o tem como deixar a guerra para tr??s.", "Sniper Americano",3f));

    }

}