package com.nasirbashak007.guessthenumber;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView T1, T2;
    Button B1;
    int min, max;
    Random rand = new Random();
    int RandomNumber;
    LinearLayout L1;
    Animation leftToRight, rightToLeft, topToBottom, bottomToUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText) findViewById(R.id.editNumber1);
        number2 = (EditText) findViewById(R.id.editNumber2);
        T1 = (TextView) findViewById(R.id.textup);
        T2 = (TextView) findViewById(R.id.texttwo);
        B1 = (Button) findViewById(R.id.button);
        L1 = (LinearLayout) findViewById(R.id.linearLayout);

        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        topToBottom = AnimationUtils.loadAnimation(this, R.anim.top_bottom);
        bottomToUp = AnimationUtils.loadAnimation(this, R.anim.bottom_toup);

        T1.startAnimation(topToBottom);
        T2.startAnimation(leftToRight);
        L1.startAnimation(rightToLeft);
        B1.startAnimation(bottomToUp);

    }

    @SuppressLint("WrongConstant")
    public void goToSecond(View view) {

        String s1 = number1.getText().toString().trim();
        String s2 = number2.getText().toString().trim();

        if (s1.length() > 0 && s2.length() > 0) {

            min = Integer.parseInt(s1);
            max = Integer.parseInt(s2);
            if (max < min) {
                Toast.makeText(getApplicationContext(), "Minimum cannot be Greater Than Maximun", Toast.LENGTH_SHORT).show();
            } else {

                RandomNumber = rand.nextInt((max - min) + 1) + min;
                String pass = String.valueOf(RandomNumber);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("number", pass);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        } else {

            Toast.makeText(getApplicationContext(), "Please Enter the Numbers",Toast.LENGTH_SHORT).show();
        }

    }

    public void exitActivity(View view) {

        //finish();
        //System.exit(0);
        //int pid = android.os.Process.myPid();
        //android.os.Process.killProcess(pid);
        finishAffinity();
    }
}
