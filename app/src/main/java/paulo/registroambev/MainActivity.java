package paulo.registroambev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

import static android.R.layout.simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    private Spinner spnUsuarios;
    private UsuarioDAO usuarioDAO;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<String> nomesUsuarios = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioDAO = new UsuarioDAO(this);
        usuarioDAO.open();
        usuarios = usuarioDAO.getAll();
        fillArray();

        spnUsuarios = (Spinner) findViewById(R.id.spnLogin);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, simple_spinner_dropdown_item, nomesUsuarios);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnUsuarios.setAdapter(spinnerArrayAdapter);

    }

    public void fillArray(){
        for(Usuario u : usuarios) {
            nomesUsuarios.add(u.getLogin());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        usuarioDAO.close();
    }
}
