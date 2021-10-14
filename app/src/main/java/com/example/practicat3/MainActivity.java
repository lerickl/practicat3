package com.example.practicat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.practicat3.models.contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager mLayoutManager;
    private static RecyclerView mRecyclerView;

    private listaContactos mStringAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mRecyclerView=  findViewById(R.id.listaString);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mStringAdapter = new listaContactos(Getcontactos());
        mRecyclerView.setAdapter(mStringAdapter);


    }



    public List<contacto> Getcontactos(){
        List<contacto> lista= new ArrayList<contacto>();
        lista.add(new contacto("erick","976123456"));
        lista.add(new contacto("antonio","123123953"));
        lista.add(new contacto("salazar","321145677"));
        lista.add(new contacto("aliaga","456123456"));
        lista.add(new contacto("prueba1","645125246"));
        lista.add(new contacto("prueba2","976123456"));
        lista.add(new contacto("prueba3","876123456"));
        lista.add(new contacto("prueba4","776123456"));
        lista.add(new contacto("prueba5","676123456"));
        lista.add(new contacto("prueba6","576123456"));

        return lista;
    }
}