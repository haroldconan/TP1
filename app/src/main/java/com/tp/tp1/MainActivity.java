package com.tp.tp1;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MESSAGE_HC";
    private Button btChiffrer,btEffacer,btdechiffrer;
    private SeekBar seekBar;
    private EditText txtEntree,txtSortie,txtSeekBar;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),
                " Hello ␣ World ␣ !!!! ",
                Toast.LENGTH_SHORT).show();
        Log.i(TAG, " Hello ␣ World ␣ !!!! ");
        btChiffrer = findViewById(R.id.btchiffrement);
        btEffacer = findViewById(R.id.bteffacer);
        btdechiffrer = findViewById(R.id.btdechiffrer);
        seekBar = findViewById(R.id.seekBar);
        txtEntree = findViewById(R.id.txtEntre);
        txtSeekBar = findViewById(R.id.txtSeekBar);
        txtSortie = findViewById(R.id.txtChiffre);
        txtSeekBar.setText(seekBar.getProgress()+"");
        context = getApplicationContext();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtSeekBar.setText(i+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Veuillez compléter le texte avec des caractère alphabétiques");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });
        txtEntree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String expression = "[A-Z\\s]+";

                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(charSequence);
                if(!matcher.matches()&& !charSequence.toString().equals("")){
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                    txtEntree.setText(charSequence.subSequence(i,i1));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEntree.setText("");
                txtSortie.setText("");
                seekBar.setProgress(1);
            }
        });

        btChiffrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtEntree.getText().toString().equals("")){


                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                    return;
                }
                txtSortie.setText(ChiffreCesar.chiffrement(txtEntree.getText().toString().toUpperCase(),seekBar.getProgress()));
            }
        });
        btdechiffrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Dechiffrement.class);
                if(txtSortie.getText().toString().equals("")){
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                    return;
                }
                intent.putExtra("sequence",txtSortie.getText().toString());
                intent.putExtra("chiffre",txtSeekBar.getText().toString());
                startActivity(intent);
            }
        });
    }
}
