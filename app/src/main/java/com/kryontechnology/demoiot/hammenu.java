package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class hammenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hammenucode();
    }

    @Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();
        hammenucode();
    }

    public void hammenucode(){
        setContentView(R.layout.activity_hammenu);
        final ImageView myhelp= (ImageView)findViewById(R.id.imageview_top_help_button);
        final ImageView myhelp_gn= (ImageView)findViewById(R.id.imageview_top_help_button_gn);
        final ImageView myperf_gy= (ImageView)findViewById(R.id.imageview_ham_perf_gy);
        final ImageView myperf_gn= (ImageView)findViewById(R.id.imageview_ham_perf_gn);
        final ImageView myop_gy= (ImageView)findViewById(R.id.imageview_ham_op_gy);
        final ImageView myop_gn= (ImageView)findViewById(R.id.imageview_ham_op_gn);
        final ImageView myhamrestart_gy= (ImageView)findViewById(R.id.imageview_ham_restart_gy);
        final ImageView myhamrestart_gn= (ImageView)findViewById(R.id.imageview_ham_restart_gn);
        final ImageView myhamshut_gy= (ImageView)findViewById(R.id.imageview_ham_shutd_gy);
        final ImageView myhamshut_gn= (ImageView)findViewById(R.id.imageview_ham_shutd_gn);
        final ImageView ham_menu_gy= (ImageView)findViewById(R.id.imageview_ham_menu_gy);

        final Thread hammenuThread = new Thread() {

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

        ham_menu_gy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                hammenuThread.start();
            }
        });



        final Thread helpThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(hammenu.this, call_help.class);
                    startActivity(i);
                }
            }
        };

        myhelp.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myhelp.setVisibility(View.GONE);
                myhelp_gn.setVisibility(View.VISIBLE);
                myhelp.setOnClickListener(null);
                helpThread.start();
            }
        });

        myperf_gy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myperf_gy.setVisibility(View.INVISIBLE);
                myperf_gn.setVisibility(View.VISIBLE);

                myop_gn.setVisibility(View.INVISIBLE);
                myhamrestart_gn.setVisibility(View.INVISIBLE);
                myhamshut_gn.setVisibility(View.INVISIBLE);
                myop_gy.setVisibility(View.VISIBLE);
                myhamrestart_gy.setVisibility(View.VISIBLE);
                myhamshut_gy.setVisibility(View.VISIBLE);

            }
        });

        myop_gy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myop_gy.setVisibility(View.INVISIBLE);
                myop_gn.setVisibility(View.VISIBLE);

                myperf_gn.setVisibility(View.INVISIBLE);
                myhamrestart_gn.setVisibility(View.INVISIBLE);
                myhamshut_gn.setVisibility(View.INVISIBLE);
                myperf_gy.setVisibility(View.VISIBLE);
                myhamrestart_gy.setVisibility(View.VISIBLE);
                myhamshut_gy.setVisibility(View.VISIBLE);

            }
        });

        myhamrestart_gy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myhamrestart_gy.setVisibility(View.INVISIBLE);
                myhamrestart_gn.setVisibility(View.VISIBLE);

                myop_gn.setVisibility(View.INVISIBLE);
                myperf_gn.setVisibility(View.INVISIBLE);
                myhamshut_gn.setVisibility(View.INVISIBLE);
                myperf_gy.setVisibility(View.VISIBLE);
                myop_gy.setVisibility(View.VISIBLE);
                myhamshut_gy.setVisibility(View.VISIBLE);

            }
        });

        myhamshut_gy.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                myhamshut_gy.setVisibility(View.INVISIBLE);
                myhamshut_gn.setVisibility(View.VISIBLE);


                myop_gn.setVisibility(View.INVISIBLE);
                myhamrestart_gn.setVisibility(View.INVISIBLE);
                myhamrestart_gn.setVisibility(View.INVISIBLE);
                myperf_gy.setVisibility(View.VISIBLE);
                myop_gy.setVisibility(View.VISIBLE);
                myhamrestart_gy.setVisibility(View.VISIBLE);

            }
        });
    }
}
