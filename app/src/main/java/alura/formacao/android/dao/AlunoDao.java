package alura.formacao.android.dao;

import java.util.ArrayList;
import java.util.List;

import alura.formacao.android.obj.Aluno;

public class AlunoDao {
    private final static List<Aluno> alunoList = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunoList.add(aluno);
    }

    public List<Aluno> listaAlunos() {
        return new ArrayList<>(alunoList);
    }
}
