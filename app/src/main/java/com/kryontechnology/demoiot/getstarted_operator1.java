package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class getstarted_operator1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getstartedoperator1code();

    }

    @Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();
        getstartedoperator1code();
    }

    public void getstartedoperator1code(){

        setContentView(R.layout.activity_getstarted_operator1);

        //Declare ImageViews from layout
        final ImageView mygetstarted_gy= (ImageView)findViewById(R.id.imageview_get_started_gy);
        final ImageView mygetstarted_gn= (ImageView)findViewById(R.id.imageview_get_started_gn);
        final ImageView myreturn= (ImageView)findViewById(R.id.imageview_return);
        final ImageView myreturn_gn= (ImageView)findViewById(R.id.imageview_return_gn);
        final ImageView myhelp= (ImageView)findViewById(R.id.imageview_top_help_button);
        final ImageView myhelp_gn= (ImageView)findViewById(R.id.imageview_top_help_button_gn);
        final ImageView myshutdown= (ImageView)findViewById(R.id.imageview_top_shut_down);
        final ImageView myshutdown_gn= (ImageView)findViewById(R.id.imageview_top_shut_down_gn);


        //Create Menu button links
        final Thread returnThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(getstarted_operator1.this, verify_operator1.class);
                    startActivity(i);
                    finish();
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

                            Intent i = new Intent(getstarted_operator1.this, call_help.class);
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

                                    Intent i = new Intent(getstarted_operator1.this, Shutdown.class);
                                    startActivity(i);
                                }
                            }
                        };


                                final Thread getstartedThread = new Thread() {

                                    @Override
                                    public void run() {
                                        try {
                                            super.run();
                                            sleep(600);  //Delay of 10 seconds
                                        } catch (Exception e) {

                                        } finally {

                                            Intent i = new Intent(getstarted_operator1.this, Scannerscreen.class);
                                            startActivity(i);
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

                myhelp.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        myhelp.setVisibility(View.GONE);
                        myhelp_gn.setVisibility(View.VISIBLE);
                        myhelp.setOnClickListener(null);
                        helpThread.start();
                    }
                });

                        myshutdown.setOnClickListener( new View.OnClickListener() {
                            public void onClick(View v) {
                                myshutdown.setVisibility(View.GONE);
                                myshutdown_gn.setVisibility(View.VISIBLE);
                                myshutdown.setOnClickListener(null);
                                shutdownThread.start();
                            }
                        });

                                mygetstarted_gy.setOnClickListener( new View.OnClickListener() {
                                    public void onClick(View v) {
                                        mygetstarted_gy.setVisibility(View.GONE);
                                        mygetstarted_gn.setVisibility(View.VISIBLE);
                                        mygetstarted_gy.setOnClickListener(null);
                                        getstartedThread.start();
                                    }
                                });
    }
}
