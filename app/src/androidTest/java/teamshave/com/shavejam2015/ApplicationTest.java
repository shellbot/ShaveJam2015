package teamshave.com.shavejam2015;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testCalculateTip() throws Exception {
        double expected;
        double reality;

        // Calculate tip for 100 at 15
        expected = 15;
        reality = Calculations.CalculateTip(100, 15);
        assertEquals(expected, reality);

        // Calculate tip for 500 at 10
        expected  = 50;
        reality = Calculations.CalculateTip(500, 10);
        assertEquals(expected, reality);
    }
}