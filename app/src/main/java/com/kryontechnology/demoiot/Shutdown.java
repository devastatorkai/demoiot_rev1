package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Shutdown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shutdown);


        //Declare ImageViews from layout
        final ImageView mycancel= (ImageView)findViewById(R.id.imageview_shutdown_cancel_gy);
        final ImageView mycancel_gn= (ImageView)findViewById(R.id.imageview_shutdown_cancel_gn);
        final ImageView mypower= (ImageView)findViewById(R.id.imageview_shutdown_power_gy);
        final ImageView mypower_gn= (ImageView)findViewById(R.id.imageview_shutdown_power_gn);


        //Create Menu button links
        final Thread mycancelThread = new Thread() {

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
                        //Create shutdown off action
                        final Thread mypowerThread = new Thread() {

                            @Override
                            public void run() {
                                try {
                                    super.run();
                                    sleep(600);  //Delay of 10 seconds
                                } catch (Exception e) {

                                } finally {

                                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                                    homeIntent.addCategory( Intent.CATEGORY_HOME );
                                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(homeIntent);
                                    finish();
                                }
                            }
                        };


        // Create onClickListeners on clickable buttons
        mycancel.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                mycancel.setVisibility(View.GONE);
                mycancel_gn.setVisibility(View.VISIBLE);
                mycancel.setOnClickListener(null);
                mycancelThread.start();
            }
        });


                mypower.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        mypower.setVisibility(View.GONE);
                        mypower_gn.setVisibility(View.VISIBLE);
                        mypower.setOnClickListener(null);
                        mypowerThread.start();
                    }
                });
            }
}
