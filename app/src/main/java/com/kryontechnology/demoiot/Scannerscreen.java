package com.kryontechnology.demoiot;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.DigitalClock;
import android.widget.TextView;
import java.util.Calendar;




public class Scannerscreen extends AppCompatActivity {


    //private CameraPreview mPreview = null;
    //private FrameLayout preview = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        scannerscreencode();


    }

  /*@Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();
        scannerscreencode();
    }*/

    public void scannerscreencode() {

        setContentView(R.layout.activity_scannerscreen);
       //Time and date text java for layout
        DigitalClock dc = (DigitalClock) findViewById(R.id.digitalClock1);
        final TextView Date = (TextView) findViewById(R.id.DATE);
        final Calendar cal = Calendar.getInstance();
            int dd = cal.get(Calendar.DAY_OF_MONTH);
            int mm = cal.get(Calendar.MONTH);
            int yy = cal.get(Calendar.YEAR);
                Date.setText(new StringBuilder()
                    .append(" DATE: ").append(dd).append("-").append(mm + 1).append("-").append(yy));

        //Declare ImageViews from layout

        final ImageView mycamerainactive = (ImageView) findViewById(R.id.imageview_camera_inactive);
        final ImageView mycameraactive = (ImageView) findViewById(R.id.imageview_camera_active);
        final ImageView myhelp = (ImageView) findViewById(R.id.imageview_top_help_button);
        final ImageView myhelp_gn = (ImageView) findViewById(R.id.imageview_top_help_button_gn);
        final ImageView myhammenu_gy = (ImageView) findViewById(R.id.imageview_ham_menu_gy);
        final ImageView mycamscan = (ImageView) findViewById(R.id.imageview_cam_scan);

        // Create our Preview view and set it as the content of our activity.
        final CameraPreview mPreview = new CameraPreview(Scannerscreen.this);
        final FrameLayout preview = (FrameLayout) findViewById(R.id.surfaceview_camera_preview);
        preview.addView(mPreview);



        //Create Menu button links

        final Thread hammenuThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(600);  //button delay of 0.6s
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(Scannerscreen.this, hammenu.class);
                    startActivity(i);
                }
            }
        };

                    final Thread helpThread = new Thread() {

                        @Override
                        public void run() {
                            try {
                                super.run();
                                sleep(600);  //button delay of 0.6s
                            } catch (Exception e) {

                            } finally {
                                //preview.removeView(mPreview);
                                //preview.refreshDrawableState();

                                Intent i = new Intent(Scannerscreen.this, call_help.class);
                                startActivity(i);
                            }
                        }
                    };




        //preview.removeView(mPreview);


                // Create an instance of Camera

                final Thread camerastartThread = new Thread() {

                    @Override
                    public void run() {
                        try {
                            super.run();
                            sleep(600);  //button delay of 0.6s
                        } catch (Exception e) {

                        } finally {

                            try {

                                //Looper.prepare();

                                mPreview.startCamera();
                                //preview.refreshDrawableState();

                            } catch(Exception e) {
                                Log.e("MyName", e.getMessage());
                            }
                        }
                    }
                };

                                // Destroy the instance of Camera

                                final Thread camerastopThread = new Thread() {

                                    @Override
                                    public void run() {
                                        try {
                                            super.run();
                                            sleep(600);  //button delay of 0.6s
                                        } catch (Exception e) {

                                        } finally {

                                            try {
                                                mPreview.surfaceDestroyed(mPreview.getHolder());
                                                mPreview.getHolder().removeCallback(mPreview);
                                                mPreview.destroyDrawingCache();
                                                mPreview.stopCamera();
                                                //preview.removeView(mPreview);
                                                //preview.refreshDrawableState();

                                            } catch(Exception e) {
                                                Log.e("MyName", e.getMessage());
                                            }
                                        }
                                    }
                                };

        // Create onClickListeners on clickable buttons

        mycamerainactive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mycamerainactive.setVisibility(View.INVISIBLE);
                mycameraactive.setVisibility(View.VISIBLE);
                //mycameraactive.setClickable(true);
                camerastartThread.start();
                mycamscan.setVisibility(View.INVISIBLE);


            }
        });

                mycameraactive.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        mycamerainactive.setVisibility(View.VISIBLE);
                        mycameraactive.setVisibility(View.INVISIBLE);
                        //mycamerainactive.setClickable(true);
                        camerastopThread.start();
                       // mycamscan.setVisibility(View.VISIBLE);
                        scannerscreencode();

                    }
                });


                        myhammenu_gy.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                hammenuThread.start();
                                camerastopThread.start();
                            }
                        });

                        myhelp.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                myhelp.setVisibility(View.GONE);
                                myhelp_gn.setVisibility(View.VISIBLE);
                                helpThread.start();
                                camerastopThread.start();
                            }
                        });

    }

}
