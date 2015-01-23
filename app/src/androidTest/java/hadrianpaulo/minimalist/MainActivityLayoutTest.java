package hadrianpaulo.minimalist;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;

/**
 * @author hadrianpaulo
 */

/**
 * The Main Activity Layout Test Class
 */

public class MainActivityLayoutTest extends ActivityInstrumentationTestCase2<MainActivity>{

    public MainActivityLayoutTest(){
        super(MainActivity.class);
    }

    /**
     * Set up testing environment
     * @throws Exception if JUnit cannot be launched and if Activities cannot be launched
     */
    @Override
    protected void setUp() throws Exception{
        super.setUp();

        setActivityInitialTouchMode(true);

        mMainActivity = getActivity();
        mMainListView = (ListView) mMainActivity.findViewById(R.id.mainList);
    }

    /**
     * testPreconditions to check whether test setup is valid
     */
    public void testPreconditions() {
        assertNotNull("mMainActivity is null", mMainActivity);
        assertNotNull("mMainListView is null", mMainListView);
    }

    /**
     *  Test for checking the MainListView layout during activity lifecycle
     *  Asserts include existence, width, height
     */
    @MediumTest
    public void testMainListView_layout(){
        final View decorView = mMainActivity.getWindow().getDecorView();

        ViewAsserts.assertOnScreen(decorView, mMainListView);

        final ViewGroup.LayoutParams layoutParams = mMainListView.getLayoutParams();

        assertNotNull(layoutParams); // Test existence
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT); // Test ListView Width
        assertEquals(layoutParams.height, WindowManager.LayoutParams.MATCH_PARENT); // Test ListView Height
    }

    private MainActivity mMainActivity;
    private ListView mMainListView;
    private Menu menu;
}