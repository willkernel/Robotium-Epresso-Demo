package com.willkernel.app.robotinumdemo;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Robotium tests extend ActivityInstrumentationTestCase2, as with all activity tests.
 * The Solo instance is initialized with the activity and retrieved instrumentation
 * instances. The tests themselves use methods from the Solo class, like enterText,
 * clickOnButton, or searchText.
 * The only downside to using Robotium is that the tests use the old JUnit 3 structure,
 * with predefined setUp and tearDown methods as shown, and all tests have to follow
 * the pattern public void testXYZ(). Still, the ease of writing the tests is remarkable
 * The test class is stored in the same androidTest hierarchy as other Android tests,
 * and executed on all emulators and connected devices simultaneously through the
 * connectedCheck task
 */
public class MainActivityRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {
    /**
     * The Solo reference from Robotium
     */
    private Solo solo;

    public MainActivityRobotiumTest() {
        super(MainActivity.class);
    }

    /**
     * Instantiate the Solo reference
     */
    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testMainActivity() {
        solo.assertCurrentActivity("MainAty", MainActivity.class);
    }

    public void testSayHello() {
        solo.enterText(0, "Dolly");
        solo.clickOnButton(getActivity().getString(R.string.welcome));
        solo.assertCurrentActivity("WelcomeAty", WelcomeActivity.class);
        solo.searchText("Hello,Dolly!");
    }

    public void tearDown() {
        solo.finishOpenedActivities();
    }
}
