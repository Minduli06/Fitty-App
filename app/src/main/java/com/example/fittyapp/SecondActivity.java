package com.example.fittyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray=new int[]{

                R.id.boat_pose,R.id.windmill_pose,R.id.vcrunches_pose,R.id.bridge_pose,R.id.twist_pose,R.id.plankll_pose,
                R.id.plank_pose,R.id.vups_pose,R.id.situps_pose,R.id.legup_pose,R.id.heel_pose,R.id.bicCrunches_pose,R.id.bcrunches_pose,

        };




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

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



    public void Imagebuttonclicked(View view) {

        for (int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){

                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(SecondActivity.this,Third1.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }







        }


    }
