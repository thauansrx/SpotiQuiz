package aps.com.br.aps_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thauan Trindade on 08/11/2018.
 */

public class MainActivity extends AppCompatActivity {

    private Button botaoIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = (Button) findViewById(R.id.buttonIniciarId);

    }

    public void iniciar(View v){
        Intent intent = new Intent(MainActivity.this, TelaQuiz.class);
        startActivity(intent);        finish();
    }

}