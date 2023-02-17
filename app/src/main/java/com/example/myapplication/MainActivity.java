package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.SubMenu;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout my_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_layout = findViewById(R.id.layout_1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        TextView view = findViewById(R.id.textView_1);
        int b = 5;
        int[] colors = new int[b];
        colors[0]= R.color.red;
        colors[1]= R.color.purple_700;
        colors[2]= R.color.black;
        colors[3]= R.color.green;
        colors[4]= R.color.white;
        Resources resources = getResources();
        switch (id){
            case R.id.item1:
                view.setText("Выбор цвета");
                return true;
            case R.id.item2:
                view.setText("Настройки");
                return true;
            case R.id.item3:
                view.setText("Сброс до заводских");

                return true;
            case R.id.item1_1 :
                my_layout.setBackgroundColor(resources.getColor(colors[0],  null));
                return true;
            case R.id.item1_2:
                my_layout.setBackgroundColor(resources.getColor(colors[1],  null));
                return true;
            case R.id.item1_3:
                my_layout.setBackgroundColor(resources.getColor(colors[2],  null));
                return true;
            case R.id.item1_4:
                my_layout.setBackgroundColor(resources.getColor(colors[3],  null));
                return true;
            case R.id.item1_5:
                int random_number1 = 1 + (int) (Math.random() * b);
                my_layout.setBackgroundColor(resources.getColor(colors[random_number1],  null));
                return true;
        }



        return super.onOptionsItemSelected(item);
    }
}