package com.androiddesdecero.espressoudemy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void errorMessageIsNotShowInitiallyTest(){
        onView(withId(R.id.loginActivityTvError))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void hintIsDisplayedInEditTextUserNameTest(){
        onView(withId(R.id.loginActivityEtUserName))
                .check(matches(withHint(R.string.login_activity_username_hint)));
    }

    @Test
    public void hintIsDisplayedInEditTextPasswordTest(){
        onView(withId(R.id.loginActivityEtPassword))
                .check(matches(withHint(R.string.login_activity_password_hint)));
    }

}