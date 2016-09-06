package com.example.ccarj_ds_w26.meuprimeirofirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase objetoRef;

    Button botaoAzul;
    Button botaoVermelho;
    TextView meuTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        botaoAzul = (Button) findViewById(R.id.botaoAzul);
        botaoVermelho = (Button) findViewById(R.id.botaoVermelho);
        meuTexto = (TextView) findViewById(R.id.meuTexto);

        objetoRef = new Firebase("https://meuprifirebaseapp.firebaseio.com/minha_cor");

        objetoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensagem = (String) dataSnapshot.getValue();
                meuTexto.setText(mensagem);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
