package com.example.student.lihaimarubatu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean maru = true;
    // メンバ変数
    Button[] button;
    Button buttonReset;
    TextView result, scores;
    int maruscores = 0;
    int batuscores = 0;
    int tiescores = 0;
    int icount = 0;
    boolean isEnd = false;
    String strMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = new Button[9];
        result = (TextView) findViewById(R.id.textView);
        for (int i = 0; i < button.length; i++) {
            String buttonID = "button" + (i + 1);

            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            button[i] = ((Button) findViewById(resID));
            button[i].setOnClickListener(this);
            button[i].setTextSize(60);
        }
        buttonReset = (Button) findViewById(R.id.button10);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });
    }

    void clearButton() {
        button[0].setText("");
        button[1].setText("");
        button[2].setText("");
        button[3].setText("");
        button[4].setText("");
        button[5].setText("");
        button[6].setText("");
        button[7].setText("");
        button[8].setText("");
        icount = 0;
    }

    //  buttonReset.setOnClickListener(this);
    @Override
    public void onClick(View v) {
        if (((Button) v).getText().equals("")) {
            if (maru) {
                ((Button) v).setText("○");

            } else {
                ((Button) v).setText("×");
                ((Button) v).setTextSize(60);

            }
            icount++;
            maru = !maru;

            // [勝ち負けの判断]

            // まず、各ボタンの状態を取得
            String[] strButton = new String[9];
            for (int i = 0; i < 9; i++) {
                strButton[i] = button[i].getText().toString();
            }

            int[][] iWinPattern = {
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                    {0, 4, 8}, {2, 4, 6}
            };
            for (int i = 0; i < 8; i++) {

                if (strButton[iWinPattern[i][0]].equals(strButton[iWinPattern[i][1]]) && strButton[iWinPattern[i][1]].equals(strButton[iWinPattern[i][2]])) {
                    strMessage = strButton[iWinPattern[i][0]];
                    if (strMessage == "○") {
                        maruscores++;
                    }
                    else if (strMessage.equals("×")) {
                        batuscores++;
                    }
                    if (strMessage.length() > 0) {
                        isEnd = true;
                        break;
                    }
                }
            }

            if (isEnd) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                        .setTitle("")
                        .setMessage(strMessage + "の勝ち !")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                clearButton();
                            }
                        });
                alertDialog.show();
                isEnd = false;
                result.setText("○" + maruscores + "     " + "×" + batuscores + "     " + "tie" + tiescores);
                return;
            }
            if (icount == 9) {
                tiescores++;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                        .setTitle("Draw")
                        .setMessage("引き分け")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                clearButton();
                            }
                        });
                alertDialog.show();
            }
          result.setText("○" + maruscores + "     " + "×" + batuscores + "     " + "tie" + tiescores);
        }
    }
}
/*
            //  Log.v("MainActivity", strBtn1 +  " " + strBtn2);
            // 各ボタンの状態から、１列になっているかをチェック
           // int muruscores=0;
            if (strBtn1.length() > 0 && strBtn2.length() > 0 && strBtn3.length() > 0) {
                if ((strBtn1 == strBtn2 && strBtn2 == strBtn3)) {
//                   MessageDialog.show(this,"good");

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("結果");
                    alertDialog.setMessage(strBtn1 + "勝った");
                    alertDialog.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    clearButton();
                                }
                            });
                    alertDialog.show();

                    if (strBtn1 == "○") {
                       maruscores++;
                   }
                    else if(strBtn1 == "×"){
                       batuscores++;
                   }
                    //  recreate();
                }
            }
            } else if (strBtn1.length() > 0 && strBtn2.length() > 0 && strBtn3.length() > 0 && strBtn4.length() > 0 && strBtn5.length() > 0 && strBtn6.length() > 0 && strBtn7.length() > 0 && strBtn8.length() > 0 && strBtn9.length() > 0) {
               // result.setText("tie");
                    tiescores++;
            }*/