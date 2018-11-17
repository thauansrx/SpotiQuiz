package thauan.com.br.spotiquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AboutUs extends AppCompatActivity {


    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        b = (Button) findViewById(R.id.visit_website);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Use when user trigger on  visit website
                String url = "https://thauansrx.github.io/SpotiQuiz/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                Intent chooser = Intent.createChooser(intent, "Open with");
                startActivity(chooser);

            }
        });

    }

    public void returnHome(View view) {

        Intent homeActivity = new Intent(AboutUs.this,Home.class);
        startActivity(homeActivity);
        finish();

    }
}
