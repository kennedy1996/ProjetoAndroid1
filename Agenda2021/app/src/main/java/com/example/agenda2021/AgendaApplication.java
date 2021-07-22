package com.example.agenda2021;

import android.app.Application;

import com.example.agenda2021.dao.AlunoDAO;
import com.example.agenda2021.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
