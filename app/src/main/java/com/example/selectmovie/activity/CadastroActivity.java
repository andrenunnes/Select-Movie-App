package com.example.selectmovie.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.selectmovie.R;
import com.example.selectmovie.helper.ConfiguracaoFirebase;
import com.example.selectmovie.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button buttonCadastrar;
    private ProgressBar progressBar;

    private Usuario usuario;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        progressBar.setVisibility(View.GONE);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textNome = campoNome.getText().toString();
                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();

                if (!textNome.isEmpty()){
                    if (!textEmail.isEmpty()){
                        if (!textSenha.isEmpty()){

                            usuario = new Usuario();
                            usuario.setNome(textNome);
                            usuario.setEmail(textEmail);
                            usuario.setSenha(textSenha);
                            cadastrar(usuario);

                        }else {
                            Toast.makeText(CadastroActivity.this,"Preencha a senha!", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(CadastroActivity.this,"Preencha o email!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(CadastroActivity.this,"Preencha o nome!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void cadastrar(Usuario usuario){
        progressBar.setVisibility(View.VISIBLE);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(CadastroActivity.this, "Cadastro com sucesso", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();

                }else{
                    progressBar.setVisibility(View.GONE);

                    String erroExcecao = "";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "Por favor digite um e-mail válido";
                    }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "Esta conta já foi cadastrada";
                    }catch (Exception e){
                        erroExcecao = "ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();


                }

            }
        });


    }

    public void inicializarComponentes(){
        campoNome = findViewById(R.id.editText_nome_cadastro);
        campoEmail = findViewById(R.id.editText_email_cadastro);
        campoSenha = findViewById(R.id.editText_Password_cadastro);
        buttonCadastrar = findViewById(R.id.button_cadastrar);
        progressBar = findViewById(R.id.progressBar_cadastro);
    }
}