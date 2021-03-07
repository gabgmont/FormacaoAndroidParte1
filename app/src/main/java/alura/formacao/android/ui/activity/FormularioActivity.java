package alura.formacao.android.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alura.formacao.android.R;
import alura.formacao.android.dao.AlunoDao;
import alura.formacao.android.obj.Aluno;

public class FormularioActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        setTitle(TITULO_APPBAR);
        configuraCampos();
        botaoSalvar();
    }

    private void botaoSalvar() {
        Button salvarAluno = findViewById(R.id.activity_formulario_botao_salvar);
        salvarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Aluno alunoCriado = criaAluno();
                salvaAluno(alunoCriado);
            }
        });
    }

    private void configuraCampos() {
        campoNome = findViewById(R.id.activity_formulario_nome);
        campoTelefone = findViewById(R.id.activity_formulario_telefone);
        campoEmail = findViewById(R.id.activity_formulario_email);
    }

    private void salvaAluno(Aluno aluno) {
        dao.salvar(aluno);

        finish();
    }

    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}