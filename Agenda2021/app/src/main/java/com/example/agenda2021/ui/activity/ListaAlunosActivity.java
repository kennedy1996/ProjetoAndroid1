package com.example.agenda2021.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda2021.R;
import com.example.agenda2021.dao.AlunoDAO;
import com.example.agenda2021.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos 2021!";
    private AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
        //configuraLista();


       /*

        List<String> alunos = new ArrayList<>(
                Arrays.asList("Kennedy", "Isabella", "Edson", "Raquel", "Mari", "Andrea", "Stela"));

       --Importante por conta do CONTEXT.. O modo correto de se instanciar o TextView é TextView aluno = new TextView(this);
       ou seja, digitar primeiro this e no enter ele já coloca depois o context
       --Comando para exibir um pop pequeno na tela :

       Toast.makeText(this, "Teste de mensagem", Toast.LENGTH_LONG).show();

       -- Comnado para exibir em lista um texto:

       TextView aluno = new TextView (this);
        aluno.setText("Kennedy Martinez esteve aqui");
        setContentView(aluno);

        --Comando para criar Array e definir para textView

                List<String> alunos = new ArrayList<>(
                Arrays.asList("Kennedy", "Isabella", "Edson"));
        TextView primeiroAluno = findViewById(R.id.textView5);
       TextView segundoAluno = findViewById(R.id.textView6);

           */
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                alunos));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                Aluno alunoEscolhido = alunos.get(posicao);
                Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class);
                vaiParaFormularioActivity.putExtra("aluno", alunoEscolhido);
                startActivity(vaiParaFormularioActivity);

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        configuraLista();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton x = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoActivity();

            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }
}