package com.androiddesdecero.espressoudemy;

import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import androidx.annotation.NonNull;
import androidx.test.espresso.matcher.BoundedMatcher;

public class ErrorEditTextMatcher {

    @NonNull
    public static Matcher<View> withError(final Matcher<String> stringMatcher){
        return new BoundedMatcher<View, EditText>(EditText.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("Error text: ");
                stringMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(EditText editText) {
                return stringMatcher.matches(editText.getError().toString());
            }
        };
    }
}
