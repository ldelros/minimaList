package hadrianpaulo.minimalist;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

    }

    @LargeTest
    public class HelloWorldEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

        public HelloWorldEspressoTest() {
            super(MainActivity.class);
        }

        @Override
        public void setUp() throws Exception {
            super.setUp();
            getActivity();
        }

        public void testListGoesOverTheFold() {
            onView(withText("Hello world!")).check(ViewAssertions.matches(isDisplayed()));
        }
    }

    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class MyJunit4ActivityInstrumentationTest
            extends ActivityInstrumentationTestCase2<MainActivity> {

        private MainActivity mActivity;

        public MyJunit4ActivityInstrumentationTest() {
            super(MainActivity.class);
        }

        @Before
        public void setUp() throws Exception {
            super.setUp();
            injectInstrumentation(InstrumentationRegistry.getInstrumentation());
            mActivity = getActivity();
        }

        @Test
        public void checkPreconditions() {
            assertNotNull(mActivity);
            // Check that Instrumentation was correctly injected in setUp()
            assertNotNull(getInstrumentation());
        }

        @After
        public void tearDown() throws Exception {
            super.tearDown();
        }

    }

 }
