package com.raj.rejas.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView seniors;
    TextView juniors;
    TextView sophomores;
    TextView freshmen;
    SeekBar seekBar;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seniors = (TextView) findViewById(R.id.seniors);
        juniors = (TextView) findViewById(R.id.juniors);
        sophomores = (TextView) findViewById(R.id.sophomores);
        freshmen = (TextView) findViewById(R.id.freshmen);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                String text = textView.getText().toString();
                int value = sharedPreferences.getInt(text, 0) + 1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(text, value);
                editor.apply();
                Toast.makeText(MainActivity.this, text + ": " + value, Toast.LENGTH_SHORT).show();
            }
        };
        seniors.setOnClickListener(click);
        juniors.setOnClickListener(click);
        sophomores.setOnClickListener(click);
        freshmen.setOnClickListener(click);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float f = (float)(14 + progress / 4.0);
                seniors.setTextSize(f);
                juniors.setTextSize(f);
                sophomores.setTextSize(f);
                freshmen.setTextSize(f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
