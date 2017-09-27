package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class verify_operator1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyoperator1code();

}

    @Override
    public void onResume() {  // After a pause OR at startup
        super.onResume();

        verifyoperator1code();


    }

    public void verifyoperator1code(){

    setContentView(R.layout.activity_verify_operator1);

    final ImageView myverifygy= (ImageView)findViewById(R.id.imageview_op_verify_gy);
    final ImageView myverifygn= (ImageView)findViewById(R.id.imageview_op_verify_gn);


/*topbar*/

    final ImageView myreturn= (ImageView)findViewById(R.id.imageview_return);
    final ImageView myreturn_gn= (ImageView)findViewById(R.id.imageview_return_gn);
    final ImageView myhelp= (ImageView)findViewById(R.id.imageview_top_help_button);
    final ImageView myhelp_gn= (ImageView)findViewById(R.id.imageview_top_help_button_gn);
    final ImageView myshutdown= (ImageView)findViewById(R.id.imageview_top_shut_down);
    final ImageView myshutdown_gn= (ImageView)findViewById(R.id.imageview_top_shut_down_gn);



    final Thread returnThread = new Thread() {

        @Override
        public void run() {
            try {
                super.run();
                sleep(600);  //Delay of 10 seconds
            } catch (Exception e) {

            } finally {

                Intent i = new Intent(verify_operator1.this, login_operator1.class);
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

                Intent i = new Intent(verify_operator1.this, call_help.class);
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

                Intent i = new Intent(verify_operator1.this, Shutdown.class);
                startActivity(i);
            }
        }
    };


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


/*topbar*/

    final Thread verifyThread = new Thread() {

        @Override
        public void run() {
            try {
                super.run();
                sleep(600);  //Delay of 10 seconds
            } catch (Exception e) {

            } finally {

                Intent i = new Intent(verify_operator1.this, getstarted_operator1.class);
                startActivity(i);
                finish();
            }
        }
    };

    myverifygy.setOnClickListener( new View.OnClickListener() {
        public void onClick(View v) {
            myverifygy.setVisibility(View.GONE);
            myverifygn.setVisibility(View.VISIBLE);
            myverifygy.setOnClickListener(null);
            verifyThread.start();
        }
    });


}

}
