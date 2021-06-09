package com.example.selectmovie.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.selectmovie.R;
import com.example.selectmovie.helper.ConfiguracaoFirebase;
import com.example.selectmovie.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button buttonEntrar;
    private TextView cadastrar;
    private EditText campoEmail, campoSenha;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        verificarUsuarioLogado();
        inicializarComponentes();


        campoEmail = findViewById(R.id.editText_email_login);
        campoSenha = findViewById(R.id.editText_Password_login);

        buttonEntrar = findViewById(R.id.button_login);

        cadastrar = findViewById(R.id.textCadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();

                if (!textEmail.isEmpty()){
                    if (!textSenha.isEmpty()){
                        usuario = new Usuario();
                        usuario.setEmail(textEmail);
                        usuario.setSenha(textSenha);
                        validarLogin(usuario);

                    }else {
                        Snackbar.make(cadastrar, "Preencha a senha!", Snackbar.LENGTH_LONG).show();
                    }

                }else {
                    Snackbar.make(cadastrar, "Preencha o e-mail!", Snackbar.LENGTH_LONG).show();
                }


            }
        });


    }

    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    public void validarLogin(Usuario usuario){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                }else{
                    Toast.makeText(LoginActivity.this, "Erro ao fazer login", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public void inicializarComponentes(){
        campoEmail = findViewById(R.id.editText_email_login);
        campoSenha = findViewById(R.id.editText_Password_login);
        buttonEntrar = findViewById(R.id.button_login);
    }


}