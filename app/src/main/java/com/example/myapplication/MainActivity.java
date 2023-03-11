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

    ConstraintLayout my_layout;
    int currentRadioButton = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_layout = findViewById(R.id.layout_1);

        // получаем объект RadioGroup
        RadioGroup radGrp = (RadioGroup)findViewById(R.id.radios);
        // обработка переключения состояния переключателя

    }

    public void onRadioButtonClicked(View view) {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radios);
        switch(view.getId()) {
            case R.id.function_1:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_1));
                Toast.makeText(getApplicationContext(),R.string.data_functions_1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_2:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_2));
                Toast.makeText(getApplicationContext(),R.string.data_functions_2, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_3:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_3));
                Toast.makeText(getApplicationContext(),R.string.data_functions_3, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_4:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_4));
                Toast.makeText(getApplicationContext(),R.string.data_functions_4, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_5:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_5));
                Toast.makeText(getApplicationContext(),R.string.data_functions_5, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_6:
                currentRadioButton = radio.indexOfChild(findViewById(R.id.function_6));
                Toast.makeText(getApplicationContext(),R.string.data_functions_6, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void onClickButton(View view){
        Intent intent = new Intent(this, ResultActivity1.class);
        EditText edit1 = findViewById(R.id.edit_firstValue);
        EditText edit2 = findViewById(R.id.edit_secondValue);
        int value1 = 0; int value2 = 0;
        if(currentRadioButton != -1){
            if(edit1.getText().toString().matches("^\\d{1,}$") |
                    edit2.getText().toString().matches("^\\d{1,}$")){
                value1 = Integer.parseInt(edit1.getText().toString());
                value2 = Integer.parseInt(edit2.getText().toString());
                if(value2 < value1){
                    Toast.makeText(getApplicationContext(),R.string.editText_warning2,Toast.LENGTH_LONG).show();
                }else{
                    intent.putExtra("function",currentRadioButton);
                    intent.putExtra("firstValue",value1);
                    intent.putExtra("secondValue",value2);
                    startActivity(intent);
                }
            }
            else{
                Toast.makeText(getApplicationContext(),R.string.editText_warning1,Toast.LENGTH_LONG).show();
            }
        }
    }
}