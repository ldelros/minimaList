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

        import java.util.Calendar;

        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.action.ViewActions.longClick;
        import static android.support.test.espresso.action.ViewActions.typeText;
        import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
        import static android.support.test.espresso.assertion.ViewAssertions.matches;
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


    }

    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class MyJunit4ActivityInstrumentationTest
            extends ActivityInstrumentationTestCase2<MainActivity> {

        private MainActivity mActivity;
        private Calendar rightNow = Calendar.getInstance();
        private String date = String.format("%1$tb %1$td", rightNow);

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

        @Test
        public void addListItem(){
            onView(withId(R.id.btnAddItem))      // withId(R.id.my_view) is a ViewMatcher
                    .perform(typeText("Hello I'm a new list item" + " --" + date), click())               // click() is a ViewAction
                    .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
        }
        public void addMultipleListItems(){
            for (int i = 0; i <= 10; i++) {
                onView(withId(R.id.btnAddItem))      // withId(R.id.my_view) is a ViewMatcher
                        .perform(typeText("Hello I'm a new list item " + (int)i + " --" + date), click())               // click() is a ViewAction
                        .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
            }
        }
        @Test
        public void deleteListItem(){
            onView(withId(R.id.btnAddItem))      // withId(R.id.my_view) is a ViewMatcher
                    .perform(longClick())               // click() is a ViewAction
                    .check(doesNotExist()); // matches(isDisplayed()) is a ViewAssertion
        }
        @Test
        public void createDeleteListItem(){
            onView(withId(R.id.btnAddItem))      // withId(R.id.my_view) is a ViewMatcher
                    .perform(typeText("Hello I'm gonna be deleted "), click())               // click() is a ViewAction
                    .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
            onView(withText("Hello I'm gonna be deleted "))
                    .perform(longClick())
                    .check(doesNotExist());
        }

        @Test
        public void createDeleteMultipleListItems(){
            for (int i = 0; i <= 10; i++) {
                onView(withId(R.id.btnAddItem))      // withId(R.id.my_view) is a ViewMatcher
                        .perform(typeText("Hello I'm gonna be deleted " + (int) i), click())               // click() is a ViewAction
                        .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
            }
            for (int i = 0; i <= 10; i++) {
                onView(withText("Hello I'm gonna be deleted " + (int) i))
                        .perform(longClick())
                        .check(doesNotExist());
            }
        }

        @After
        public void tearDown() throws Exception {
            super.tearDown();
        }

    }

}