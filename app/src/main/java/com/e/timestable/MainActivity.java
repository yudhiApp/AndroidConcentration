package com.e.timestable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar =  findViewById(R.id.seekBar);
        listView =   findViewById(R.id.listView);
        seekBar.setMax(20);
        seekBar.setMin(1);
        seekBar.setProgress(0);
        generateTimesTable(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generateTimesTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<Integer> arrayMulti = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            arrayMulti.add(i * timesTableNumber);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayMulti);
        listView.setAdapter(arrayAdapter);
    }

}
