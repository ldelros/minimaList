package hadrianpaulo.minimalist;

import android.app.Activity;
import com.robotium.recorder.executor.Executor;

@SuppressWarnings("rawtypes")
public class MainActivityExecutor extends Executor {

	@SuppressWarnings("unchecked")
	public MainActivityExecutor() throws Exception {
		super((Class<? extends Activity>) Class.forName("hadrianpaulo.minimalist.MainActivity"),  "hadrianpaulo.minimalist.R.id.", new android.R.id(), false, false, "1422587977163");
	}

	public void setUp() throws Exception { 
		super.setUp();
	}
}
