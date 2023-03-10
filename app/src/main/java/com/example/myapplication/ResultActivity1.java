package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity1 extends AppCompatActivity {

    int value1;
    int value2;
    String func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null) {
            value1 = arguments.getInt("firstValue");
            value2 = arguments.getInt("secondValue");
            func= arguments.getString("function");
        }
        setContentView(R.layout.activity_result1);
    }
    public void onClickButton(View view){
        TextView view1 = (TextView)findViewById(R.id.textView_result1);
        TextView view2 = (TextView)findViewById(R.id.textView_result2);
        TextView view3 = (TextView)findViewById(R.id.textView_result3);

           view1.setText(Integer.toString(value1));
           view2.setText(Integer.toString(value2));
           view3.setText(func);

    }
}