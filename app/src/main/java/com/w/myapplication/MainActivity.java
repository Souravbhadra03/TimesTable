package com.w.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ;
    public void generate(int times)
    {
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            arrayList.add(Integer.toString(times*i));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listView);
        final SeekBar seekBar= findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTable;
                if(i<min) {
                    timesTable=min;
                    seekBar.setProgress(min);
                }
                else
                {
                    timesTable=i;
                }
                generate(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);
    }
}
