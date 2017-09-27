package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.EditText;
import static android.R.attr.key;
import static java.lang.Thread.sleep;


public class login_operator1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginoperator1code();

    }

    @Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();
        loginoperator1code();
    }

    private EditText mEtPassword ;


    public void loginoperator1code(){

        setContentView(R.layout.activity_login_operator1);



        //Declare ImageViews from layout

        final ImageView mypad1_gy= (ImageView)findViewById(R.id.imageview_pad_1_gy);
        final ImageView mypad2_gy= (ImageView)findViewById(R.id.imageview_pad_2_gy);
        final ImageView mypad3_gy= (ImageView)findViewById(R.id.imageview_pad_3_gy);
        final ImageView mypad4_gy= (ImageView)findViewById(R.id.imageview_pad_4_gy);
        final ImageView mypad5_gy= (ImageView)findViewById(R.id.imageview_pad_5_gy);
        final ImageView mypad6_gy= (ImageView)findViewById(R.id.imageview_pad_6_gy);
        final ImageView mypad7_gy= (ImageView)findViewById(R.id.imageview_pad_7_gy);
        final ImageView mypad8_gy= (ImageView)findViewById(R.id.imageview_pad_8_gy);
        final ImageView mypad9_gy= (ImageView)findViewById(R.id.imageview_pad_9_gy);
        final ImageView mypad0_gy= (ImageView)findViewById(R.id.imageview_pad_0_gy);
        final ImageView mypad1_dg= (ImageView)findViewById(R.id.imageview_pad_1_dg);
        final ImageView mypad2_dg= (ImageView)findViewById(R.id.imageview_pad_2_dg);
        final ImageView mypad3_dg= (ImageView)findViewById(R.id.imageview_pad_3_dg);
        final ImageView mypad4_dg= (ImageView)findViewById(R.id.imageview_pad_4_dg);
        final ImageView mypad5_dg= (ImageView)findViewById(R.id.imageview_pad_5_dg);
        final ImageView mypad6_dg= (ImageView)findViewById(R.id.imageview_pad_6_dg);
        final ImageView mypad7_dg= (ImageView)findViewById(R.id.imageview_pad_7_dg);
        final ImageView mypad8_dg= (ImageView)findViewById(R.id.imageview_pad_8_dg);
        final ImageView mypad9_dg= (ImageView)findViewById(R.id.imageview_pad_9_dg);
        final ImageView mypad0_dg= (ImageView)findViewById(R.id.imageview_pad_0_dg);
        final ImageView mypad_del_gy= (ImageView)findViewById(R.id.imageview_pad_del_gy);
        final ImageView mypad_del_dg= (ImageView)findViewById(R.id.imageview_pad_del_dg);
        final ImageView mypadenter= (ImageView)findViewById(R.id.imageview_pad_enter_gy);
        final ImageView mypadinfo= (ImageView)findViewById(R.id.imageview_pad_info_gy);
        final ImageView mypadinfo_gn= (ImageView)findViewById(R.id.imageview_pad_info_gn);
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

                    Intent i = new Intent(login_operator1.this, team_selection.class);
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

                                Intent i = new Intent(login_operator1.this, call_help.class);
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

                                            Intent i = new Intent(login_operator1.this, Shutdown.class);
                                            startActivity(i);
                                        }
                                    }
                                };

                                            final Thread mypadinfoThread = new Thread() {

                                                @Override
                                                public void run() {
                                                    try {
                                                        super.run();
                                                        sleep(600);  //Delay of 10 seconds
                                                    } catch (Exception e) {

                                                    } finally {

                                                        Intent i = new Intent(login_operator1.this, password_info.class);
                                                        startActivity(i);
                                                    }
                                                }
                                            };

                                                        final Thread op1enterThread = new Thread() {

                                                            @Override
                                                            public void run() {
                                                                try {
                                                                    super.run();
                                                                    sleep(600);  //Delay of 10 seconds
                                                                } catch (Exception e) {

                                                                } finally {

                                                                    Intent i = new Intent(login_operator1.this, verify_operator1.class);
                                                                    startActivity(i);
                                                                    finish();
                                                                }
                                                            }
                                                        };


//                                                                final Thread genwaitThread = new Thread() {
//
//                                                                    @Override
//                                                                    public void run() {
//                                                                        try {
//                                                                            super.run();
//                                                                            sleep(300);  //Delay of 10 seconds
//                                                                        } catch (Exception e) {
//                                                                        }
//                                                                        finally {
//
//                                                                            mypad1_dg.setVisibility(View.INVISIBLE);
//                                                                        }
//                                                                    }
//                                                                };



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


                                mypadinfo.setOnClickListener( new View.OnClickListener() {
                                    public void onClick(View v) {
                                        /*btnsnd.start();*/
                                        mypadinfo.setVisibility(View.GONE);
                                        mypadinfo_gn.setVisibility(View.VISIBLE);
                                        mypadinfo.setOnClickListener(null);
                                        mypadinfoThread.start();
                                    }
                                });


                                        mypadenter.setOnClickListener( new View.OnClickListener() {
                                            public void onClick(View v) {
                                                /*loadsound.start();*/
                                                myreturn.setOnClickListener(null);
                                                op1enterThread.start();
                                            }
                                        });

                                                mypad1_gy.setOnClickListener(new View.OnClickListener() {
                                                    public void onClick(View v) {

                                                        mypad1_dg.setVisibility(View.VISIBLE);
//                                                        genwaitThread.start();
                                                        String me = mypad1_gy.getTag().toString();
//                                                        AddPasswordChar(me);
                                                    }
                                                 });

                                                        mypad2_gy.setOnClickListener(new View.OnClickListener() {
                                                            public void onClick(View v) {

                                                                mypad2_dg.setVisibility(View.VISIBLE);
//                                                                genwaitThread.start();
                                                                String me = mypad1_gy.getTag().toString();
//                                                                AddPasswordChar(me);
                                                            }
                                                        });


                                                                mypad3_gy.setOnClickListener(new View.OnClickListener() {
                                                                    public void onClick(View v) {

                                                                        mypad3_dg.setVisibility(View.VISIBLE);
//                                                                        genwaitThread.start();
                                                                        String me = mypad1_gy.getTag().toString();
//                                                                        AddPasswordChar(me);
                                                                    }
                                                                });

                                                                        mypad4_gy.setOnClickListener(new View.OnClickListener() {
                                                                            public void onClick(View v) {

                                                                                mypad4_dg.setVisibility(View.VISIBLE);
//                                                                                genwaitThread.start();
                                                                                String me = mypad1_gy.getTag().toString();
//                                                                                AddPasswordChar(me);
                                                                            }
                                                                        });

                                                                                mypad5_gy.setOnClickListener(new View.OnClickListener() {
                                                                                    public void onClick(View v) {

                                                                                        mypad5_dg.setVisibility(View.VISIBLE);
//                                                                                        genwaitThread.start();
                                                                                        String me = mypad1_gy.getTag().toString();
//                                                                                        AddPasswordChar(me);
                                                                                    }
                                                                                });

                                                                                        mypad6_gy.setOnClickListener(new View.OnClickListener() {
                                                                                            public void onClick(View v) {

                                                                                                mypad6_dg.setVisibility(View.VISIBLE);
//                                                                                                genwaitThread.start();
                                                                                                String me = mypad1_gy.getTag().toString();
//                                                                                                AddPasswordChar(me);
                                                                                            }
                                                                                        });

                                                                                                mypad7_gy.setOnClickListener(new View.OnClickListener() {
                                                                                                    public void onClick(View v) {

                                                                                                        mypad7_dg.setVisibility(View.VISIBLE);
//                                                                                                        genwaitThread.start();
                                                                                                        String me = mypad1_gy.getTag().toString();
//                                                                                                        AddPasswordChar(me);
                                                                                                    }
                                                                                                });

                                                                                                        mypad8_gy.setOnClickListener(new View.OnClickListener() {
                                                                                                            public void onClick(View v) {

                                                                                                                mypad8_dg.setVisibility(View.VISIBLE);
//                                                                                                                genwaitThread.start();
                                                                                                                String me = mypad1_gy.getTag().toString();
//                                                                                                                AddPasswordChar(me);
                                                                                                            }
                                                                                                        });

                                                                                                                mypad9_gy.setOnClickListener(new View.OnClickListener() {
                                                                                                                    public void onClick(View v) {

                                                                                                                        mypad9_dg.setVisibility(View.VISIBLE);
//                                                                                                                        genwaitThread.start();
                                                                                                                        String me = mypad1_gy.getTag().toString();
//                                                                                                                        AddPasswordChar(me);
                                                                                                                    }
                                                                                                                });

//                                                                                                                        mypad0_gy.setOnClickListener(new View.OnClickListener() {
//                                                                                                                            public void onClick(View v) {
//
//                                                                                                                                mypad0_dg.setVisibility(View.VISIBLE);
////                                                                                                                                genwaitThread.start();
//                                                                                                                                String me = mypad1_gy.getTag().toString();
////                                                                                                                                AddPasswordChar(me);
//                                                                                                                            }
//                                                                                                                        });

                                                                                                                                mypad_del_gy.setOnClickListener(new View.OnClickListener() {
                                                                                                                                    public void onClick(View v) {

                                                                                                                                        mypad_del_dg.setVisibility(View.VISIBLE);
//                                                                                                                                        genwaitThread.start();
                                                                                                                                        String me = mypad1_gy.getTag().toString();
//                                                                                                                                        AddPasswordChar(me);
                                                                                                                                    }
                                                                                                                                });

    }


    private void AddPasswordChar(String pass) {
        mEtPassword.append(pass);

        UpdateDots();
    }

    private void RemovePasswordChar() {
        String passwordStr = mEtPassword.getText().toString();
        if (passwordStr.length() > 0) {
            String newPasswordStr = new StringBuilder(passwordStr)
                    .deleteCharAt(passwordStr.length() - 1).toString();
            mEtPassword.setText(newPasswordStr);
        }

        UpdateDots();
    }

    private void UpdateDots() {

        final ImageView mypasslen0_gy= (ImageView)findViewById(R.id.imageview_passw_zero);
        final ImageView mypasslen1_gy= (ImageView)findViewById(R.id.imageview_passw_1);
        final ImageView mypasslen2_gy= (ImageView)findViewById(R.id.imageview_passw_2);
        final ImageView mypasslen3_gy= (ImageView)findViewById(R.id.imageview_passw_3);
        final ImageView mypasslen4_gy= (ImageView)findViewById(R.id.imageview_passw_complete);

        mypasslen0_gy.setVisibility(mEtPassword.length() == 0 ? View.VISIBLE : View.INVISIBLE);
        mypasslen1_gy.setVisibility(mEtPassword.length() == 1 ? View.VISIBLE : View.INVISIBLE);
        mypasslen2_gy.setVisibility(mEtPassword.length() == 2 ? View.VISIBLE : View.INVISIBLE);
        mypasslen3_gy.setVisibility(mEtPassword.length() == 3 ? View.VISIBLE : View.INVISIBLE);
        mypasslen4_gy.setVisibility(mEtPassword.length() == 4 ? View.VISIBLE : View.INVISIBLE);
    }


}