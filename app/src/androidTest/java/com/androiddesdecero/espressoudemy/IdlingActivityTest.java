package com.androiddesdecero.espressoudemy;

import com.androiddesdecero.espressoudemy.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

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
    





    @After
    public void unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(
                EspressoIdlingResource.getIdlingResource()
        );
    }
}