package com.androiddesdecero.espressoudemy;

import android.os.IBinder;
import android.view.WindowManager;

import androidx.test.espresso.Root;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ToastMatcher extends TypeSafeMatcher<Root> {

    private static final int MAX_FAILURES = 5;
    private int failures = 0;

    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override
    protected boolean matchesSafely(Root root) {
        int type = root.getWindowLayoutParams().get().type;
        if(type == WindowManager.LayoutParams.TYPE_TOAST){
            IBinder windowToken = root.getDecorView().getWindowToken();
            IBinder appToken = root.getDecorView().getApplicationWindowToken();

            if(windowToken == appToken){
                return true;
            }
        }

        return (++failures > MAX_FAILURES);
    }
}
