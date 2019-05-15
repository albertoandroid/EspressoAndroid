package com.androiddesdecero.espressoudemy.utils;

import android.os.Handler;

public class WebServiceMock {

    public void login(String user, String password, final Callback callback){

        new Handler().postDelayed(new Runnable() {
            public void run() {
                boolean check = true;
                if(check){
                    callback.onSuccess("Usuario Correcto");
                }else{
                    callback.onFailure("Usuario Incorrecto");
                }
            };
        }, 5000);
    }
}
