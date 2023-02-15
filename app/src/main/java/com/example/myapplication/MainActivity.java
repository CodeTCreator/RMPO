package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.SeekBar_1);
        TextView textView = findViewById(R.id.Seek_value);
        TextView textView1 = findViewById(R.id.textView_1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(String.valueOf(progress));
                textView1.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void sendMessage(View view) {
        TextView textView = findViewById(R.id.textView_1);
        EditText editText = findViewById(R.id.editText_1);
        textView.setText("Вы вввели:" + editText.getText());
    }
    public void Reset_value(View view){
        TextView textView = findViewById(R.id.textView_1);
        EditText editText = findViewById(R.id.editText_1);
        textView.setText(R.string.data_view_1);
        editText.getText().clear();
    }
}