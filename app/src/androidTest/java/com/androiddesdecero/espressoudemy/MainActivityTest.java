package com.androiddesdecero.espressoudemy;

import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.openLinkWithText;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
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

        //View Matcher
        onView(withId(R.id.mainActivityTv));

        onView(withText("Prueba Espresso"));

        onView(withContentDescription("elemento TextView"));

        onView(withHint("texto hint"));

        onView(allOf(withText("Prueba Espresso"), withParent(withId(R.id.mainActivityRl))));

        onView(allOf(withId(R.id.mainActivityTv), isDisplayed()));

        onView(withText(startsWith("Prueba")));

        onView(allOf(instanceOf(TextView.class), withId(R.id.mainActivityTv)));


        //View Action

        onView(withId(R.id.mainActivityEt))
                .perform(typeText("30"));

        onView(withId(R.id.mainActivityEt))
                .perform(replaceText("34"));

        onView(withId(R.id.mainActivityEt))
                .perform(clearText());

        onView(withId(R.id.mainActivityBt))
                .perform(click());

        onView(withId(R.id.mainActivityRl))
                .perform(swipeLeft());

        onView(withId(R.id.mainActivityEt))
                .perform(typeText("34")
                        , ViewActions.closeSoftKeyboard());

        onView(withId(R.id.mainActivityTv))
                .perform(openLinkWithText("www.google.es"));


        //View Assertions

        onView(withId(R.id.mainActivityTv))
                .check(matches(isDisplayed()));

        onView(withId(R.id.mainActivityTv))
                .check(matches(withText("Prueba Espresso")));

        onView(withId(R.id.mainActivityTv))
                .check(matches(withText(R.string.app_name)));

        onView(withId(R.id.mainActivityTv))
                .check(isCompletelyLeftOf(withId(R.id.mainActivityEt)));

        onView(withId(R.id.mainActivityTv))
                .check(doesNotExist());

    }


}