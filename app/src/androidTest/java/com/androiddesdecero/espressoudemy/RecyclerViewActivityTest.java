package com.androiddesdecero.espressoudemy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewActivityTest {

    @Rule
    public ActivityScenarioRule<RecyclerViewActivity> activityRule =
            new ActivityScenarioRule<>(RecyclerViewActivity.class);

    @Test
    public void recyclerViewFirstTest(){
        onView(withText("Monica"))
                .check(matches(isDisplayed()));
    }
}