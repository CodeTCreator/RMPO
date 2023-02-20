package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout my_layout;

    int layout_default_color;
    ColorStateList d_view1_colorText;
    float d_view2_sizeText;
    int d_view3_gravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_layout = findViewById(R.id.layout_1);

        //Получение цвета layout
        ColorDrawable  viewcolor = (ColorDrawable) my_layout.getBackground();
        layout_default_color = viewcolor.getColor();

        //Получаем значения textview
        TextView textView1 = findViewById(R.id.textView_1);
        d_view1_colorText = textView1.getTextColors();
        TextView textView2 = findViewById(R.id.textView_2);
        d_view2_sizeText = textView2.getTextSize();
        TextView textView3 = findViewById(R.id.textView_3);
        d_view3_gravity = textView3.getGravity();

        //Регистрируем
        registerForContextMenu(textView1);
        registerForContextMenu(textView2);
        registerForContextMenu(textView3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textView_1:
                getMenuInflater().inflate(R.menu.context_menu1, menu);
                break;
            case R.id.textView_2:
                getMenuInflater().inflate(R.menu.context_menu2, menu);
                break;
            case R.id.textView_3:
                getMenuInflater().inflate(R.menu.context_menu3, menu);
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        TextView view = findViewById(R.id.textView_1);
        TextView view3 = findViewById(R.id.textView_3);
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
                view.setText("Text View 1!");
                //Получение textview
                TextView view_1 = findViewById(R.id.textView_1);
                TextView view_2 = findViewById(R.id.textView_2);
                TextView view_3 = findViewById(R.id.textView_3);

                //Установка значений по умолчанию
                view_1.setTextColor(d_view1_colorText);
                view_2.setTextSize(TypedValue.COMPLEX_UNIT_PX,d_view2_sizeText);
                view_3.setGravity(d_view3_gravity);
                my_layout.setBackgroundColor(layout_default_color);
                return true;

            case R.id.item1_1 :
                my_layout.setBackgroundColor(resources.getColor(colors[0],  null));
                view3.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);
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

    @Override
    public boolean onContextItemSelected(MenuItem item){
        TextView view1 = findViewById(R.id.textView_1);
        TextView view2 = findViewById(R.id.textView_2);
        TextView view3 = findViewById(R.id.textView_3);
        switch (item.getItemId()) {
            case R.id.item1_CM1:
                //view1.setBackgroundColor(getResources().getColor(R.color.red,null));
                view1.setTextColor(getResources().getColor(R.color.red,null));
                return true;
            case R.id.item2_CM1:
                view1.setTextColor(getResources().getColor(R.color.green,null));
                return true;
            case R.id.item3_CM1:
                view1.setTextColor(getResources().getColor(R.color.purple_700,null));
                return true;
            case R.id.item4_CM1:
                view1.setTextColor(getResources().getColor(R.color.orange,null));
                return true;
            case R.id.item5_CM1:
                view1.setTextColor(getResources().getColor(R.color.white,null));
                return true;
            case R.id.item1_CM2:
                view2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                        Integer.parseInt(getResources().getString(R.string.contextMenu2_item1)));
                return true;
            case R.id.item2_CM2:
                view2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                        Integer.parseInt(getResources().getString(R.string.contextMenu2_item2)));
                return true;
            case R.id.item3_CM2:
                view2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                        Integer.parseInt(getResources().getString(R.string.contextMenu2_item3)));
                return true;
            case R.id.item4_CM2:
                view2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                        Integer.parseInt(getResources().getString(R.string.contextMenu2_item4)));
                return true;
            case R.id.item5_CM2:
                view2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                        Integer.parseInt(getResources().getString(R.string.contextMenu2_item5)));
                return true;
            case R.id.item1_CM3:
                view3.setGravity(Gravity.LEFT);
                return true;
            case R.id.item2_CM3:
                view3.setGravity(Gravity.CENTER);
                return true;
            case R.id.item3_CM3:
                view3.setGravity(Gravity.RIGHT);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}