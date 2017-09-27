package com.kryontechnology.demoiot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.media.MediaPlayer;


public class loading_Screen extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);


        //Declare ImageViews from layout
        final ImageView myImageView= (ImageView)findViewById(R.id.imageview_logo1);
        final ImageView myImageView2= (ImageView)findViewById(R.id.imageview_logo2);
        final ImageView myImageView3= (ImageView)findViewById(R.id.imageview_load1);
        final ImageView myImageView4= (ImageView)findViewById(R.id.imageview_load2);

        //Declare Animations
        final Animation myFadeInAnimation4 = AnimationUtils.loadAnimation(this, R.anim.fadeinquick);
        final Animation myFadeInAnimation3 = AnimationUtils.loadAnimation(this, R.anim.fadeinquick);
        final Animation myFadeInAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation myFadeInAnimation1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation myFadeOutAnimation1 = AnimationUtils.loadAnimation(this, R.anim.fadeout);


        //After swirl animation wait before entering team_selection
        final Thread loadThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);  //Delay of 5 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(loading_Screen.this,
                            team_selection.class);
                    startActivity(i);
                    finish();
                }
            }
        };

        //Start logo fade in main logo

        myImageView.startAnimation(myFadeInAnimation1);

        //Start logo fade out main logo

        myFadeInAnimation1.setAnimationListener(new AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
                                            public void onAnimationEnd(Animation arg0) {

                                                // start animation2 when animation1 ends (continue)

                                                myImageView.startAnimation(myFadeOutAnimation1);
                                                myImageView.setVisibility(View.GONE);
                                            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

                                    //Start Ecopearl Text fade in

                                    myFadeOutAnimation1.setAnimationListener(new AnimationListener(){

                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationEnd(Animation arg0) {
                                            // start animation2 when animation1 ends (continue)
                                            myImageView2.startAnimation(myFadeInAnimation2);
                                            myImageView2.setVisibility(View.VISIBLE);

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {

                                        }
                                    });

                                                                //Start Launching Device Text fade in

                                                                myFadeInAnimation2.setAnimationListener(new AnimationListener(){

                                                                @Override
                                                                public void onAnimationStart(Animation animation) {

                                                                }

                                                                @Override
                                                                public void onAnimationEnd(Animation arg0) {
                                                                    // start animation2 when animation1 ends (continue)
                                                                    myImageView3.startAnimation(myFadeInAnimation3);
                                                                    myImageView3.setVisibility(View.VISIBLE);
                                                                }


                                                                    @Override
                                                                public void onAnimationRepeat(Animation animation) {

                                                                }
                                                            });

                                                                                            //Start Loading icon fade in and animation

                                                                                            myFadeInAnimation3.setAnimationListener(new AnimationListener(){

                                                                                            @Override
                                                                                            public void onAnimationStart(Animation animation) {

                                                                                            }

                                                                                            @Override
                                                                                            public void onAnimationEnd(Animation arg0) {
                                                                                                // Start animation2 when animation1 ends
                                                                                                myImageView4.startAnimation(myFadeInAnimation4);
                                                                                                myImageView4.setVisibility(View.VISIBLE);
                                                                                                Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotating);
                                                                                                a.setDuration(700);
                                                                                                myImageView4.startAnimation(a);
                                                                                                loadThread.start();
                                                                                            }

                                                                                            @Override
                                                                                            public void onAnimationRepeat(Animation animation) {

                                                                                            }
                                                                                        });


    }


    public native String stringFromJNI();

}

