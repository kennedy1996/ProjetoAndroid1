package com.example.agenda2021.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda2021.R;
import com.example.agenda2021.dao.AlunoDAO;
import com.example.agenda2021.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.agenda2021.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos 2021!";
    private AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
        configuraLista();
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_list_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if(itemId == R.id.activity_lista_alunos_menu_remover){

            AdapterView.AdapterContextMenuInfo  menuInfo =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
            remove(alunoEscolhido);
        }

        return super.onContextItemSelected(item);
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_alunos_listview);
        configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void remove(Aluno aluno) {

        dao.remove(aluno);
        adapter.remove(aluno);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
                abreFormularioModoEditaAluno(alunoEscolhido);

            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this,
                FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ListaAlunosAdapter(this);
        listaDeAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton x = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbreFormularioModoInsereAluno();

            }
        });
    }

    private void AbreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }
}