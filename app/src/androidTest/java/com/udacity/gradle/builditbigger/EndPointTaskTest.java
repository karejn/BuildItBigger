package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ekzhu.jokerviewer.JokeViewerActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;



@RunWith(AndroidJUnit4.class)
public class EndPointTaskTest {
    @Rule
    public IntentsTestRule<MainActivity> mainActivityIntentsTestRule=
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void testFetchedJoke() {
        onView(allOf(withId(R.id.btn_joke))).perform(click());

        intended(hasComponent(hasClassName(JokeViewerActivity.class.getName())));

        onView(allOf(withId(R.id.tv_joke_viewer))).check(matches(not(withText(""))));
    }
}
