package com.example.fittyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Third1 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmillis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third1);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intvalue=Integer.valueOf(buttonvalue);

        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_boat);
                break;

            case 2:
                setContentView(R.layout.activity_bcrunches);
                break;
            case 3:
                setContentView(R.layout.activity_bicrunches);
                break;
            case 4:
                setContentView(R.layout.activity_heel);
                break;
            case 5:
                setContentView(R.layout.activity_legup);
                break;
            case 6:
                setContentView(R.layout.activity_situps);
                break;
            case 7:
                setContentView(R.layout.activity_vups);
                break;
            case 8:
                setContentView(R.layout.activity_plankrot);
                break;
            case 9:
                setContentView(R.layout.activity_plank);
                break;
            case 10:
                setContentView(R.layout.activity_twist);
                break;
            case 11:
                setContentView(R.layout.activity_bridge);
                break;
            case 12:
                setContentView(R.layout.activity_vcrunches);
                break;
            case 13:
                setContentView(R.layout.activity_windmil);
                break;


        }

        startBtn=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MTimeRunning){
                    stoptimer();
                }
                else {
                    startTimer();
                }
            }
        });

        private void stoptimer(){
            countDownTimer.cancel();
            MTimeRunning=false;
            startBtn.setText("START");
        }

        private void startTimer(){
            // Get the current time value from a TextView and convert it to seconds
            final CharSequence value1 = mtextview.getText();
            String num1 = value1.toString();
            String num2 = num1.substring(0, 2);
            String num3 = num1.substring(3, 5);
            final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);

            // Set the timer duration in milliseconds
            MTimeLeftinmillis = number * 1000;

            // Create a new CountDownTimer object and start it
            countDownTimer = new CountDownTimer(MTimeLeftinmillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Update the remaining time and display it in a TextView
                    MTimeLeftinmillis = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    // Do something when the timer finishes, e.g. start a new activity
                    int newvalue=Integer.valueOf(buttonvalue)+1;
                    if (newvalue<=7){
                        Intent intent=new Intent(Third1.this,Third1.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value",String.valueOf(newvalue));
                        startActivity(intent);
                    }
                    else{
                        newvalue=1;
                        Intent intent=new Intent(Third1.this,Third1.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value",String.valueOf(newvalue));
                        startActivity(intent);
                    }
                }
            }.start();

            // Set the timer running flag and update the start button text
            MTimeRunning = true;
            startBtn.setText("Pause");
        }






    }

//    private void stoptimer(){
//
//        countDownTimer.cancel();
//        MTimeRunning=false;
//        startBtn.setText("START");
//    }




    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void updateTimer(){

        int minutes = (int) MTimeLeftinmillis/60000;
        int seconds = (int) MTimeLeftinmillis%60000/1000;

        String timeLeftText="";
        if(minutes<10){

            timeLeftText="0";
            timeLeftText=timeLeftText+minutes+":";
            if(seconds<10){
                timeLeftText+="0";
                timeLeftText+=seconds;
                mtextview.setText(timeLeftText);


            }


        }
}

}
