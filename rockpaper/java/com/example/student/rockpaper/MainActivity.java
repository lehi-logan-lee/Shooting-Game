package com.example.student.rockpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton rock, paper, scissor;
    int hands[] = new int[3];
    ImageView me,computer;
    TextView result,scores;
    int iscores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hands[0] = R.drawable.rock;
        hands[1] = R.drawable.paper;
        hands[2] = R.drawable.scissor;
        me = (ImageView) findViewById(R.id.me);
        computer =(ImageView) findViewById(R.id.computer);
        rock = (ImageButton) findViewById(R.id.rock);
        paper = (ImageButton) findViewById(R.id.paper);
        scissor = (ImageButton) findViewById(R.id.scissor);
        result = (TextView) findViewById(R.id.textview);
        scores = (TextView) findViewById(R.id.scores);
        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissor.setOnClickListener(this);

    }

    @Override
    public void onClick(View press) {
        Random random = new Random();
        int n = random.nextInt(3);
        int hand=0;
//        static int iscores = 0;
        //0:rock 1:paper 2:scissors
        if (press ==rock ) {
            hand = 0;
        }else if (press == paper ) {
            hand = 1;
        }else if (press == scissor ) {
            hand = 2;
        }
        me.setImageResource(hands[hand]);
        computer.setImageResource(hands[n]);
        int teacher = (hand - n) +3;

        if (teacher%3 == 0) {
            result.setText("tie");
        }else if (teacher%3 == 1) {
            result.setText("you lose");
            iscores --;
        }else if (teacher%3 == 2) {
            result.setText("you win");
            iscores ++;
        }
        scores.setText("" + iscores);


    }
}


