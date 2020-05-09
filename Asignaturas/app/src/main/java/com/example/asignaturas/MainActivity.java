package com.example.asignaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView myList;
    List<String>asignaturas;
    MyAdapterList Adapter;
    EditText editAsig;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.ListView);
        fillList();
        selectItemList();
    }

    void fillList(){
        asignaturas=new ArrayList<>();
        asignaturas.add("Facultativa II");
        asignaturas.add("Planificación TIC");
        asignaturas.add("Investigación Aplicada");

        Adapter=new MyAdapterList(this, R.layout.item_list, asignaturas);
        myList.setAdapter(Adapter);
    }
    void selectItemList(){
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item seleccionado:  "+asignaturas.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void agregar(){
        btnAdd=(Button)findViewById(R.id.btnAgregar);
        editAsig=(EditText)findViewById(R.id.editTextAsignatura);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editAsig.getText().toString().contentEquals("")){
                    Toast.makeText(MainActivity.this, "Campo Vacío", Toast.LENGTH_LONG).show();
                }
                else{
                    editAsig=(EditText)findViewById(R.id.editTextAsignatura);
                    asignaturas.add(editAsig.getText().toString());
                    editAsig.setText("");
                }
            }
        });
    }
}
