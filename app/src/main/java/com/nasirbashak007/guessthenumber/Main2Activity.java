package com.nasirbashak007.guessthenumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    String stringRandom;
    int num;
    EditText editText;
    static int RandomNumber;
    int chances = 0;

    TextView textView;
    Animation DisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        stringRandom = bundle.getString("number").toString();
        RandomNumber = Integer.valueOf(stringRandom);

        editText = (EditText) findViewById(R.id.editnumber);
        textView = (TextView) findViewById(R.id.textView);
        DisplayText = AnimationUtils.loadAnimation(this, R.anim.linear_botton_top_guessnumber);

    }


    public void ClaculateTheResult(View view) {

        String s = editText.getText().toString().trim();

        if (s.length() > 0) {

            num = Integer.parseInt(s);

            if (chances < 6) {

                calculateTheResult();

            } else {

                String message = "Sorry You are out of Chances,Please Try again.";

                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("keys", message);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter a Number", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("ResourceAsColor")
    public void calculateTheResult() {

        chances++;

        if (num < RandomNumber) {

            String message = "The Number " + num + " is Too Small";
            textView.setText(message);
            textView.setTextColor(R.color.colorAccent);
            textView.startAnimation(DisplayText);
            editText.setText("");

        } else if (num > RandomNumber) {

            String message = "The Number " + num + " is Too Big";
            textView.setText(message);
            textView.setTextColor(R.color.colorPrimary);
            textView.startAnimation(DisplayText);
            editText.setText("");

        } else if (num == RandomNumber) {

            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);

            String message = "Wow you won, the Number " + num + " is Correct. You took " + chances + " chances.";
            Bundle bundle = new Bundle();
            bundle.putString("keys", message);
            intent.putExtras(bundle);
            startActivity(intent);
        }


    }

}
