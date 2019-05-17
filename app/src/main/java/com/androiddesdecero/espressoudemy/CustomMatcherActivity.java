package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomMatcherActivity extends AppCompatActivity {

    private EditText customMatcherActivityEtUserName;
    private EditText customMatcherActivityEtPassword;
    private Button customMatcherActivityBtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_matcher);

        setUpView();
    }

    private void setUpView(){
        customMatcherActivityEtUserName = findViewById(R.id.customMatcherActivityEtUserName);
        customMatcherActivityEtPassword = findViewById(R.id.customMatcherActivityEtPassword);
        customMatcherActivityBtLogin = findViewById(R.id.customMatcherActivityBtLogin);

        customMatcherActivityBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = customMatcherActivityEtUserName.getText().toString();
                String password = customMatcherActivityEtPassword.getText().toString();

                if(userName!=null && userName.length()<4){
                    customMatcherActivityEtUserName.setError(getString(R.string.login_activity_username_error));
                    return;
                }
                if(password!=null && password.length()<4){
                    customMatcherActivityEtPassword.setError(getString(R.string.login_activity_password_error));
                    return;
                }
                doLoginBackEnd(userName, password);
            }
        });
    }

    private void doLoginBackEnd(String userName, String password){
        if(userName.equals("Alberto")&& password.equals("1234")){
            Intent intent = new Intent(getApplicationContext(), SpinnerActivity.class);
            intent.putExtra("USER", userName);
            startActivity(intent);
        }
    }
}
