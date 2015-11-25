package com.khoga.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myView = (MyView)findViewById(R.id.myView1);
        myView.setSquareCol(Color.BLUE);
        myView.setLabelCol(Color.YELLOW);
        myView.setLabelText("Press Me!");

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setSquareCol(Color.GREEN);
                myView.setLabelCol(Color.MAGENTA);
                myView.setLabelText("Hello World!");

            }
        });
    }
}
