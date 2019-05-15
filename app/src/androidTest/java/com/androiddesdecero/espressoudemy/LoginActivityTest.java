package com.androiddesdecero.espressoudemy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    //@Rule
    //public ActivityScenarioRule<LoginActivity> activityRule =
    //        new ActivityScenarioRule<>(LoginActivity.class);

    @Rule
    public IntentsTestRule<LoginActivity> activityRule =
            new IntentsTestRule<>(LoginActivity.class);

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

    @Test
    public void userNameLenghRuleErrorTest(){
        onView(withId(R.id.loginActivityEtUserName))
                .perform(typeText("alb"));

        onView(withId(R.id.loginActivityBtLogin))
                .perform(click());

        onView(withId(R.id.loginActivityTvError))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.login_activity_username_error)));
    }

    @Test
    public void passwordLenghRuleErrorTest(){

        onView(withId(R.id.loginActivityEtUserName))
                .perform(typeText("alberto"));

        onView(withId(R.id.loginActivityEtPassword))
                .perform(typeText("123"));

        onView(withId(R.id.loginActivityBtLogin))
                .perform(click());

        onView(withId(R.id.loginActivityTvError))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.login_activity_password_error)));
    }

    @Test
    public void validUserNameAndPasswordNotShowErrorMessageTest(){
        onView(withId(R.id.loginActivityEtUserName))
                .perform(typeText("alberto"));

        onView(withId(R.id.loginActivityEtPassword))
                .perform(typeText("1234"));

        onView(withId(R.id.loginActivityBtLogin))
                .perform(click());

        onView(withId(R.id.loginActivityTvError))
                .check(matches(not(isDisplayed())));

    }

    @Test
    public void validUserNameAndPasswordGoToRecyclerViewActivityTest(){
        onView(withId(R.id.loginActivityEtUserName))
                .perform(typeText("Alberto"));

        onView(withId(R.id.loginActivityEtPassword))
                .perform(typeText("1234"));

        onView(withId(R.id.loginActivityBtLogin))
                .perform(click());

        intended(hasComponent(RecyclerViewActivity.class.getName()));
        intended(hasExtra("USER", "Alberto"));

        intended(allOf(
                hasComponent(RecyclerViewActivity.class.getName()),
                hasExtra("USER", "Alberto")
        ));
    }

}