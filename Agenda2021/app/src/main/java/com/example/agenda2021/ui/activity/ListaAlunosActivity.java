package com.example.agenda2021.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.agenda2021.R;
import com.example.agenda2021.dao.AlunoDAO;
import com.example.agenda2021.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

<<<<<<< HEAD
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> parent of 5924511 (Simplificação de Código)

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD

        dao.salva(new Aluno("Kennedy", "234", "23"));
=======
>>>>>>> parent of 5924511 (Simplificação de Código)
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos 2021!");
        setContentView(R.layout.activity_lista_alunos);

         FloatingActionButton x = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        // FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class));

            }
        });

        AlunoDAO dao = new AlunoDAO();


        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                dao.todos()));

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
<<<<<<< HEAD

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
                Intent vaiParaFormActivity = new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class);
                vaiParaFormActivity.putExtra("aluno", alunoEscolhido);
                startActivity(vaiParaFormActivity);

                // Jogando no Log do sistema Log.i("aluno", "" + alunoEscolhido);
            }
        });
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
=======
>>>>>>> parent of 5924511 (Simplificação de Código)
}