package com.example.fittyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button1=findViewById(R.id.startfitness1);
        button2=findViewById((R.id.startfitness2));


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });

    }
    public void setSupportActionBar(Toolbar toolbar){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://gymplanapp.com/privacy-policy/"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.id_term) {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://gymplanapp.com/terms/"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.rate) {
            try {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName())));

            }catch (Exception ex){

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
            }
            return true;
        }
        if (id == R.id.more) {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/search?q=fitness+apps&c=apps"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.share) {

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the Best App For Fitness \n By this app streach your body \n this is a free download app \n" + "https://play.google.com/store/apps/details?id=com.example.fittyapp&hl=en";
            String sharehub = "Fitness App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));
            return true;
        }
        return true;
    }



        public void beforeage18(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);


    }

    public void food(View view) {
        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);



    }
}