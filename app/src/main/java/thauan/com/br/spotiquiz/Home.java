package thauan.com.br.spotiquiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Thauan Trindade on 16/11/2018.
 */

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void startGame(View view) {
        Intent gameActivity = new Intent(Home.this,Game.class);
        startActivity(gameActivity);
        finish();
    }


    public void openAboutUs(View view) {
        Intent gameActivity = new Intent(Home.this,AboutUs.class);
        startActivity(gameActivity);
        finish();
    }
}
