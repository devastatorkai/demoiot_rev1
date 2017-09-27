package com.kryontechnology.demoiot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class password_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_info);

        //Declare ImageViews from layout
        final ImageView myreport_gy= (ImageView)findViewById(R.id.imageview_passw_report_gy);
        final ImageView myreport_gn= (ImageView)findViewById(R.id.imageview_passw_report_gn);
        final ImageView myreportinfo= (ImageView)findViewById(R.id.imageview_passw_info);
        final ImageView myreportcomplete= (ImageView)findViewById(R.id.imageview_passw_complete);
        final ImageView myreturn= (ImageView)findViewById(R.id.imageview_return);
        final ImageView myreturn_gn= (ImageView)findViewById(R.id.imageview_return_gn);

        //Create Menu button links
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


                myreport_gy.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        myreport_gy.setVisibility(View.GONE);
                        myreport_gn.setVisibility(View.VISIBLE);
                    }
                });

    }
}
