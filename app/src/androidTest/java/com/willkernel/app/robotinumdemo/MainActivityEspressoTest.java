package com.willkernel.app.robotinumdemo;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by willkernel on 2017/12/6.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityEspressoTest() {
        super(MainActivity.class);
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHelloWorld() {
        onView(withId(R.id.editText)).perform(typeText("Dolly"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.welcomeTv)).check(matches(withText(containsString("Dolly"))));
    }
}
