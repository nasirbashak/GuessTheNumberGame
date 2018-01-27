package com.nasirbashak007.guessthenumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    TextView textView;
    String message;
    Animation DisplayText,ButtonAnim,g,a,m,e,o,v,ee,r;
    Button button,G,A,M,E,O,V,EE,RR;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button)findViewById(R.id.button);
        G =(Button)findViewById(R.id.text_G);
        A =(Button)findViewById(R.id.text_A);
        M =(Button)findViewById(R.id.text_M);
        E =(Button)findViewById(R.id.text_E);
        O =(Button)findViewById(R.id.text_O);
        V =(Button)findViewById(R.id.text_V);
        EE =(Button)findViewById(R.id.text_EE);
        RR =(Button)findViewById(R.id.text_R);
        textView = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("keys").toString().trim();

        textView.setText(message);
        g = AnimationUtils.loadAnimation(this,R.anim.linear_bottom_to_top);
        a = AnimationUtils.loadAnimation(this,R.anim.linear_top_to_bottom);
        m = AnimationUtils.loadAnimation(this,R.anim.linear_bottom_to_top);
        e = AnimationUtils.loadAnimation(this,R.anim.linear_top_to_bottom);
        o = AnimationUtils.loadAnimation(this,R.anim.linear_bottom_to_top);
        v = AnimationUtils.loadAnimation(this,R.anim.linear_top_to_bottom);
        ee = AnimationUtils.loadAnimation(this,R.anim.linear_bottom_to_top);
        r = AnimationUtils.loadAnimation(this,R.anim.linear_top_to_bottom);

        G.startAnimation(g);
        A.startAnimation(a);
        M.startAnimation(m);
        E.startAnimation(e);
        O.startAnimation(o);
        V.startAnimation(v);
        EE.startAnimation(ee);
        RR.startAnimation(r);



        DisplayText = AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        ButtonAnim = AnimationUtils.loadAnimation(this,R.anim.right_to_left);
        textView.startAnimation(DisplayText);
        button.startAnimation(ButtonAnim);

    }

    public void callSecondActivity(View view) {

        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);

    }
}
