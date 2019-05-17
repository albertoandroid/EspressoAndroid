package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinnerActivitySp;
    private TextView spinnerActivityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        setUpView();
        setUpDataSpinner();
    }

    private void setUpView(){
        spinnerActivityTv = findViewById(R.id.spinnerActivityTv);
        spinnerActivitySp = findViewById(R.id.spinnerActivitySp);

        spinnerActivitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    spinnerActivityTv.setText((CharSequence) parent.getSelectedItem());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setUpDataSpinner(){
        List<String> nombres = new ArrayList<>();
        nombres.add("Alberto");
        nombres.add("Manuel");
        nombres.add("Laura");
        nombres.add("Monica");
        nombres.add("Pablo");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nombres);

        spinnerActivitySp.setAdapter(dataAdapter);

    }
}
