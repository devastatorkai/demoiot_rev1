package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Console;

public class team_selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        teamselectioncode();

    }


    @Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();

        teamselectioncode();


    }


    private void teamselectioncode() {
        setContentView(R.layout.activity_team_selection);


        final ImageView mysingleoperatorgrey = (ImageView) findViewById(R.id.imageview_single_operator_grey);
        final ImageView mysingleoperatorgreen = (ImageView) findViewById(R.id.imageview_single_operator_green);
        final ImageView myteamoperatorgrey = (ImageView) findViewById(R.id.imageview_operation_team_operator_grey);
        final ImageView myteamoperatorgreen = (ImageView) findViewById(R.id.imageview_operation_team_operator_green);
        final ImageView mychooseoperatorgrey = (ImageView) findViewById(R.id.imageview_chooseoperation_grey);
        final ImageView mychooseoperatorgreen = (ImageView) findViewById(R.id.imageview_chooseoperation_green);
        final ImageView myhelp = (ImageView) findViewById(R.id.imageview_top_help_button);
        final ImageView myhelp_gn = (ImageView) findViewById(R.id.imageview_top_help_button_gn);
        final ImageView myshutdown = (ImageView) findViewById(R.id.imageview_top_shut_down);
        final ImageView myshutdown_gn = (ImageView) findViewById(R.id.imageview_top_shut_down_gn);


        final Thread teamThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(team_selection.this, login_operator1.class);
                    startActivity(i);
                }
            }
        };


        final Thread helpThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(team_selection.this, call_help.class);

                    startActivity(i);

                }
            }
        };

        final Thread shutdownThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(team_selection.this, Shutdown.class);
                    startActivity(i);
                }
            }
        };


        mysingleoperatorgrey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*loadsound.start();*/
                mysingleoperatorgrey.setVisibility(View.GONE);
                mysingleoperatorgreen.setVisibility(View.VISIBLE);
                mychooseoperatorgreen.setVisibility(View.GONE);
                mychooseoperatorgrey.setVisibility(View.VISIBLE);
                myteamoperatorgrey.setOnClickListener(null);
                teamThread.start();
            }
        });


        myteamoperatorgrey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myteamoperatorgrey.setVisibility(View.GONE);
                myteamoperatorgreen.setVisibility(View.VISIBLE);
                mychooseoperatorgreen.setVisibility(View.GONE);
                mychooseoperatorgrey.setVisibility(View.VISIBLE);
                myteamoperatorgrey.setOnClickListener(null);
                teamThread.start();
            }
        });


        myhelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                myhelp.setVisibility(View.INVISIBLE);
                myhelp_gn.setVisibility(View.VISIBLE);
                myhelp.setOnClickListener(null);
                helpThread.start();
            }
        });


        myshutdown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myshutdown.setVisibility(View.GONE);
                myshutdown_gn.setVisibility(View.VISIBLE);
                myshutdown.setOnClickListener(null);
                shutdownThread.start();
            }
        });
    }
}


