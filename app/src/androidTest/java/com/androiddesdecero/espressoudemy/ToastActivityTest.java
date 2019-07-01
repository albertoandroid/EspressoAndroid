package com.androiddesdecero.espressoudemy;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ToastActivityTest {

    @Rule
    public ActivityScenarioRule<ToastActivity> activityRule =
            new ActivityScenarioRule<>(ToastActivity.class);


    @Test
    public void toastMessageIsDisplayedTest(){
        onView(withId(R.id.btToast))
                .perform(click());
        onView(withText("Testeando un toast"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}