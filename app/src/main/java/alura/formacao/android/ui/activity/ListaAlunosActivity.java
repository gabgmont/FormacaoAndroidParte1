package alura.formacao.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.formacao.android.R;
import alura.formacao.android.dao.AlunoDao;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton addAlunoBotao = findViewById(R.id.acticity_lista_alunos_fab_add_aluno);
        abrirFormulario(addAlunoBotao);
    }

    private void abrirFormulario(FloatingActionButton addAlunoBotao) {
        addAlunoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ListaAlunosActivity.this, FormularioActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        imprimeListaAluno(dao);
    }

    private void imprimeListaAluno(AlunoDao dao) {
        ListView listaAlunos = findViewById(R.id.acticity_lista_alunos_listview);
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.listaAlunos()));
    }
}
