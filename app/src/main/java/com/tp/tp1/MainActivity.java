package com.tp.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MESSAGE_HC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),
                " Hello ␣ World ␣ !!!! ",
                Toast.LENGTH_SHORT).show();
        Log.i(TAG, " Hello ␣ World ␣ !!!! ");

    }
}
