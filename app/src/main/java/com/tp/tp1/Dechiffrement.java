package com.tp.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.tp.tp1.ChiffreCesar.dechiffrement;

public class Dechiffrement extends AppCompatActivity {

    Button btretour;
    EditText txtSequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_dechiffrement_layout);
        txtSequence = findViewById(R.id.txtsequence);
        btretour = findViewById(R.id.btretour);
        txtSequence.setText(dechiffrement((String)getIntent().getSerializableExtra("sequence"),Integer.parseInt((String)getIntent().getSerializableExtra("chiffre"))));

        btretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
