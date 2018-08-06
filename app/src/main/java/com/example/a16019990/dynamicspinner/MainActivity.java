package com.example.a16019990.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);

        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);

        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        alNumbers.addAll(Arrays.asList(strNumbers));
        aaNumbers.notifyDataSetChanged();



        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                switch(position) {
                        case 0:
                            String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                            alNumbers.addAll(Arrays.asList(strNumbers));
                            aaNumbers.notifyDataSetChanged();
                            spn2.setSelection(2);
                            break;
                        case 1:
                            strNumbers = getResources().getStringArray(R.array.odd_numbers);
                            alNumbers.addAll(Arrays.asList(strNumbers));
                            aaNumbers.notifyDataSetChanged();
                            spn2.setSelection(2);
                            break;

                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}