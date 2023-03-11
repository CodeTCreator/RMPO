package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {


        int value1;
        int value2;
        int func;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle arguments = getIntent().getExtras();

            if(arguments!=null) {
                value1 = arguments.getInt("firstValue");
                value2 = arguments.getInt("secondValue");
                func= arguments.getInt("function") + 1;
            }
            setContentView(R.layout.activity_main);
        }
        public void onClickButton(View view){
            TextView view1 = (TextView)findViewById(R.id.textView_result2);
            view1.setText(Double.toString(calculateExpression(func,value1,value2)));
        }

        public void onClickBack(View view){
            Intent intent = new Intent();
            intent.setAction("com.test.calculating");
            intent.addCategory("com.test.second.category");
            startActivity(intent);
        }

        public double calculateExpression(int expr,int limit1, int limit2){
            switch (expr){
                case 1:
                    return (Math.pow(limit2,3)/3) - (Math.pow(limit1,3)/3);
                case 2:
                    return (((Math.pow(limit2,4)/4)+(Math.pow(limit2,3)/3)-5*limit2)  -
                            (((Math.pow(limit1,4)/4)+(Math.pow(limit1,3)/3))-5*limit1));
                case 3:
                    return (((Math.pow(limit2,5)/5)+(Math.pow(limit2,3)/3)+25*limit2) -
                            (((Math.pow(limit1,5)/5)+(Math.pow(limit1,3)/3))+25*limit1));
                case 4:

                    return ((0.5*limit2 + (Math.sin((2*limit2))/4)) -
                            (0.5*limit1 + (Math.sin((2*limit1))/4)));
                case 5:
                    return ((0.5*limit2 - Math.sin((2*limit2))/4) -
                            (0.5*limit1 - Math.sin((2*limit1))/4));
                case 6:
                    return ((Math.pow(limit2,3)/3) + 5*Math.pow(limit2,2) + 25 * limit2)
                            - ((Math.pow(limit1,3)/3) + 5*Math.pow(limit1,2) + 25 * limit1);
            }
            return 0;
        }
}