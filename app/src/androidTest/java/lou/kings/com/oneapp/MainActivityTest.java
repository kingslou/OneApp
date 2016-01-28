package lou.kings.com.oneapp;

import android.test.InstrumentationTestCase;

/**
 * Created by jin on 2016.01.28.
 */
public class MainActivityTest extends InstrumentationTestCase {

    public void test_Invaild() throws Exception{
        int x = 3;
        int y = 4;
        int resutlt = x+y;
        assertEquals(8,resutlt);
    }

    public void test_Vaild() throws Exception{
        int x = 3;
        int y = 4;
        int resutlt = x+y;
        assertEquals(7,resutlt);
    }
}
