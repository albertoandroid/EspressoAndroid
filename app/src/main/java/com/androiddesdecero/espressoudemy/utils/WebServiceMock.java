package com.androiddesdecero.espressoudemy.utils;

public class WebServiceMock {

    public void login(String user, String password, final Callback callback){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(4000);
                }catch (Exception e){

                }
                boolean check = true;
                if(check){
                    callback.onSuccess("Usuario Correcto");
                }else {
                    callback.onFailure("Usuario Incorrecto");
                }
            }
        };
    }
}
