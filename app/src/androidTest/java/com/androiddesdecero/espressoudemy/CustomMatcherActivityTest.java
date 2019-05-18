package com.androiddesdecero.espressoudemy;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CustomMatcherActivityTest {

    //@Rule
    //public ActivityScenarioRule<CustomMatcherActivity> activityRule =
    //        new ActivityScenarioRule<>(CustomMatcherActivity.class);

    @Rule
    public IntentsTestRule<CustomMatcherActivity> activityRule =
            new IntentsTestRule<>(CustomMatcherActivity.class);

    @Test
    public void checkWithWrongUserNameTest(){
        onView(withId(R.id.customMatcherActivityEtUserName))
                .perform(typeText("al"));

        onView(withId(R.id.customMatcherActivityBtLogin))
                .perform(click());

        onView(withId(R.id.customMatcherActivityEtUserName))
                .check(matches(
                      ErrorEditTextMatcher.withError(
                              Matchers.containsString("Username ha de ser más de 4 caracteres"))));
    }

    @Test
    public void checkWithWrongPasswordTest(){
        onView(withId(R.id.customMatcherActivityEtUserName))
                .perform(typeText("alberto"));

        onView(withId(R.id.customMatcherActivityEtPassword))
                .perform(typeText("123"));

        onView(withId(R.id.customMatcherActivityBtLogin))
                .perform(click());

        onView(withId(R.id.customMatcherActivityEtPassword))
                .check(matches(
                        ErrorEditTextMatcher.withError(
                                Matchers.containsString("Password ha de ser más de 4 caracteres"))));
    }

    @Test
    public void validUserNameAndPasswordGoToSpinnerActivityTest(){
        onView(withId(R.id.customMatcherActivityEtUserName))
                .perform(typeText("Alberto"));

        onView(withId(R.id.customMatcherActivityEtPassword))
                .perform(typeText("1234"));

        onView(withId(R.id.customMatcherActivityBtLogin))
                .perform(click());

        intended(hasComponent(SpinnerActivity.class.getName()));
    }


}