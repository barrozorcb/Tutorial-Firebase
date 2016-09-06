package com.example.ccarj_ds_w26.meuprimeirofirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Firebase objetoRef;

    ListView minhaLista;
    ArrayList<String> minhaListaDeTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        minhaLista = (ListView) findViewById(R.id.listView);

        objetoRef = new Firebase("https://meuprifirebaseapp.firebaseio.com/");

        Firebase refMinhaLista = objetoRef.child("Lista_Tarefas");

        FirebaseListAdapter<String> adaptador = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1,refMinhaLista) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(s);
            }
        };

        minhaLista.setAdapter(adaptador);






    }
}
