package com.androiddesdecero.espressoudemy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SpinnerActivityTest {

    @Rule
    public ActivityScenarioRule<SpinnerActivity> activityRule =
            new ActivityScenarioRule<>(SpinnerActivity.class);


    @Test
    public void spinnerTest(){
        onView(withId(R.id.spinnerActivitySp))
                .perform(click());

        onData(anything())
                .atPosition(1)
                .perform(click());

        onView(withId(R.id.spinnerActivitySp))
                .check(matches(withSpinnerText(containsString("Manuel"))));
    }
}