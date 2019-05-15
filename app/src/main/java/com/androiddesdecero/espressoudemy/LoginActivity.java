package com.androiddesdecero.espressoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText loginActivityEtUserName;
    private EditText loginActivityEtPassword;
    private Button loginActivityBtLogin;
    private TextView loginActivityTvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpView();
    }

    private void setUpView(){
        loginActivityEtUserName = findViewById(R.id.loginActivityEtUserName);
        loginActivityEtPassword = findViewById(R.id.loginActivityEtPassword);
        loginActivityBtLogin = findViewById(R.id.loginActivityBtLogin);
        loginActivityTvError = findViewById(R.id.loginActivityTvError);

        loginActivityBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginActivityTvError.setVisibility(View.GONE);
                String userName = loginActivityEtUserName.getText().toString();
                String password = loginActivityEtPassword.getText().toString();

                if(userName!= null && userName.length()< 4){
                    loginActivityTvError.setText(R.string.login_activity_username_error);
                    loginActivityTvError.setVisibility(View.VISIBLE);
                    return;
                }
                if(userName!= null && password.length()< 4){
                    loginActivityTvError.setText(R.string.login_activity_password_error);
                    loginActivityTvError.setVisibility(View.VISIBLE);
                    return;
                }
                doLoginBackEnd(userName, password);
            }
        });
    }

    private void doLoginBackEnd(String userName, String password){

        if(userName.equals("Alberto")&& password.equals("1234")){
            Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
            intent.putExtra("USER", userName);
            startActivity(intent);
        }

    }
}
