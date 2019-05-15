package com.androiddesdecero.espressoudemy;

import com.androiddesdecero.espressoudemy.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class IdlingActivityTest {


    @Rule
    public ActivityScenarioRule<IdlingActivity> activityRule =
            new ActivityScenarioRule<>(IdlingActivity.class);

    @Before
    public void registerIdlingResource(){
        IdlingRegistry.getInstance().register(
                EspressoIdlingResource.getIdlingResource()
        );
    }

    @Test
    public void textIsDisplayedAfterWebServiceTest(){

        onView(withId(R.id.idlingActivityBt))
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.idlingActivityTv))
                .check(matches(isDisplayed()))
                .check(matches(withText("Alberto")));
    }

    @After
    public void unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(
                EspressoIdlingResource.getIdlingResource()
        );
    }
}