package com.androiddesdecero.espressoudemy;

import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void myFirstTest(){
        onView(withId(R.id.mainActivityTv));

        onView(withText("Prueba Espresso"));

        onView(withContentDescription("elemento TextView"));

        onView(withHint("texto hint"));

        onView(allOf(withText("Prueba Espresso"), withParent(withId(R.id.mainActivityRl))));

        onView(allOf(withId(R.id.mainActivityTv), isDisplayed()));

        onView(withText(startsWith("Prueba")));

        onView(allOf(instanceOf(TextView.class), withId(R.id.mainActivityTv)));
    }


}