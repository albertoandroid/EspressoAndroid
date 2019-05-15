package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText activityMain2EtMiFirstEditText;
    private Button activityMain2BtReset;
    private TextView activityMain2TvMiFirstTest;
    private Button activityMain2btChange;
    private Button activityMain2BtGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setUpView();
    }

    private void setUpView(){
        activityMain2EtMiFirstEditText = findViewById(R.id.activityMain2EtMiFirstEditText);
        activityMain2BtReset = findViewById(R.id.activityMain2BtReset);
        activityMain2TvMiFirstTest = findViewById(R.id.activityMain2TvMiFirstTest);
        activityMain2btChange = findViewById(R.id.activityMain2btChange);
        activityMain2BtGoToLogin = findViewById(R.id.activityMain2BtGoToLogin);

        activityMain2BtReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityMain2TvMiFirstTest.setText("Reset Texto");
            }
        });

        activityMain2btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityMain2TvMiFirstTest.setText(activityMain2EtMiFirstEditText.getText().toString());
            }
        });

        activityMain2BtGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}
