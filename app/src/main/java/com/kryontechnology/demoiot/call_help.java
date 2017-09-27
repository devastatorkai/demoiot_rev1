package com.kryontechnology.demoiot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.os.Handler;

public class call_help extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_help);


        //Declare IageViews
        final ImageView myreturn= (ImageView)findViewById(R.id.imageview_return);
        final ImageView myreturn_gn= (ImageView)findViewById(R.id.imageview_return_gn);
        final ImageView dot1= (ImageView)findViewById(R.id.imageview_help_dot_01);


        //Create Dot Animation
        final int[] imageArray = { R.drawable.help_dot_01,
                R.drawable.help_dot_02, R.drawable.help_dot_03,
                R.drawable.help_dot_04,};

                                        final Handler handler = new Handler();
                                        Runnable runnable = new Runnable() {
                                            int i = 0;

                                            public void run() {
                                                dot1.setImageResource(imageArray[i]);
                                                dot1.setVisibility(View.VISIBLE);
                                                i++;
                                                if (i > imageArray.length - 1) {
                                                    i = 0;
                                                }
                                                handler.postDelayed(this, 700);
                                            }
                                        };
                                        handler.postDelayed(runnable, 700);

        //Kill Activity so you xcan return to last activity on stack
        final Thread returnThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    finish();
                }
            }


        };

        // Create onClickListeners on clickable buttons
        myreturn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myreturn.setVisibility(View.GONE);
                myreturn_gn.setVisibility(View.VISIBLE);
                myreturn.setOnClickListener(null);
                returnThread.start();
            }
        });



    }
}

