package com.androiddesdecero.espressoudemy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class Main2ActivityTest {

    @Rule
    public ActivityScenarioRule<Main2Activity> activityRule =
            new ActivityScenarioRule<>(Main2Activity.class);

    @Test
    public void isDisplayedOnTheScreenTest(){
        onView(withText("Mi primer Expresso test"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void isDisplayedOnTheScreenWithIdTest(){
        onView(withId(R.id.activityMain2TvMiFirstTest))
                .check(matches(isDisplayed()));
    }

    @Test
    public void ensureResetWorkTest(){
        onView(withId(R.id.activityMain2BtReset))
                .perform(click());

        onView(withId(R.id.activityMain2TvMiFirstTest))
                .check(matches(withText("Reset Texto")));
    }

    @Test
    public void ensureChangeEditTextWorkTest(){
        onView(withId(R.id.activityMain2EtMiFirstEditText))
                .perform(typeText("Prueba")
                , ViewActions.closeSoftKeyboard());

        onView(withId(R.id.activityMain2btChange))
                .perform(click());

        onView(withId(R.id.activityMain2TvMiFirstTest))
                .check(matches(withText("Prueba")));
    }

    @Test
    public void isDisplayedOnTheScreenErrorTest(){
        onView(withText("No me muestra"))
                .check(matches(isDisplayed()));
    }
}