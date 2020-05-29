package com.example.proyectorecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter myAdapter;
    ArrayList<Model> models=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recyclerview1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new Adapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList(){
        Model m=new Model();
        m=new Model();
        m.setTitle("Facultativa II");
        m.setDescription("Descripción de Facultativa II");
        m.setImg(R.drawable.app);
        m.setTeacher("Saira");
        m.setDay("Jueves");
        m.setTime("2:00pm");
        m.setDate("28/05/2020");
        models.add(m);

        m=new Model();
        m.setTitle("Investigación");
        m.setDescription("Descripción de Investigación");
        m.setImg(R.drawable.files);
        m.setTeacher("Jazcar");
        m.setDay("Jueves");
        m.setTime("1:00pm");
        m.setDate("28/05/2020");
        models.add(m);

        m=new Model();
        m.setTitle("Planificación TIC");
        m.setDescription("Descripción de Planificación TIC");
        m.setImg(R.drawable.pc);
        m.setTeacher("Miriam");
        m.setDay("Miércoles");
        m.setTime("1:00pm");
        m.setDate("27/05/2020");
        models.add(m);
        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btagregar:
                Intent intent=new Intent();
                final Dialog dlg = new Dialog(this);
                dlg.setContentView(R.layout.agregar);
                dlg.setTitle("Agregar asignatura");
                dlg.setCancelable(false);


                Button btAgregar = (Button)dlg.findViewById(R.id.btagregar);
                Button btCancelar = (Button)dlg.findViewById(R.id.btcancelar);

                btAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText asignaturaText = (EditText)dlg.findViewById(R.id.asignaturaText);
                        EditText descripcionText = (EditText)dlg.findViewById(R.id.descripcionText);
                        EditText profesorText = (EditText)dlg.findViewById(R.id.teacherText);
                        EditText diaText = (EditText)dlg.findViewById(R.id.dayText);
                        EditText horaText = (EditText)dlg.findViewById(R.id.timeText);
                        EditText fechaText = (EditText)dlg.findViewById(R.id.dateText);
                        Model m = new Model();
                        m = new Model();
                        m.setTitle(asignaturaText.getText().toString());
                        m.setDescription(descripcionText.getText().toString());
                        m.setTeacher(profesorText.getText().toString());
                        m.setDay(diaText.getText().toString());
                        m.setTime(horaText.getText().toString());
                        m.setDate(fechaText.getText().toString());
                        m.setImg(R.drawable.files);

                        asignaturaText.setText("");
                        descripcionText.setText("");
                        profesorText.setText("");
                        diaText.setText("");
                        horaText.setText("");
                        fechaText.setText("");
                        models.add(m);
                        mRecyclerView.setAdapter(myAdapter);
                        dlg.cancel();
                    }
                });
                dlg.show();
                return true;
            case R.id.btcerrar:
                this.finish();
                return true;
            default:
                return true;
        }
    }
}
