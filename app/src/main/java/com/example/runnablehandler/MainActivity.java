package com.example.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    int sayi;
    Runnable r;
    Handler h;
    Button startButton,resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        startButton = (Button) findViewById(R.id.startButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        sayi =0;
    }
    public void start(View v){
        startButton.setEnabled(false);
        h = new Handler();
      r = new Runnable() {
          @Override
          public void run() {
              tv1.setText("Time: " + sayi);
              sayi++;
              h.postDelayed(r,1000);
          }
      };
      h.post(r);
    }

    public void reset(View v){
        startButton.setEnabled(true);
        h.removeCallbacks(r);
        sayi=0;
        tv1.setText("Time: " + sayi);
    }


}