package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.espressoudemy.utils.Callback;
import com.androiddesdecero.espressoudemy.utils.EspressoIdlingResource;
import com.androiddesdecero.espressoudemy.utils.WebServiceMock;

public class IdlingActivity extends AppCompatActivity {

    private TextView idlingActivityTv;
    private Button idlingActivityBt;
    private Button idlingActivityBtGoToSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idling);

        setUpView();
    }

    private void setUpView(){
        idlingActivityTv = findViewById(R.id.idlingActivityTv);
        idlingActivityBt = findViewById(R.id.idlingActivityBt);
        idlingActivityBtGoToSpinner = findViewById(R.id.idlingActivityBtGoToSpinner);
        idlingActivityBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarDatos();
            }
        });
        idlingActivityBtGoToSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(getApplicationContext(), SpinnerActivity.class));
            }
        });
    }

    private void cargarDatos(){
        EspressoIdlingResource.increment();
        WebServiceMock webServiceMock = new WebServiceMock();
        webServiceMock.login("Alberto", "1234", new Callback() {
            @Override
            public void onSuccess(String response) {
                if(!EspressoIdlingResource.getIdlingResource().isIdleNow()){
                    EspressoIdlingResource.decrement();
                }
                idlingActivityTv.setText("Alberto");
            }

            @Override
            public void onFailure(String response) {

            }
        });
    }

}
