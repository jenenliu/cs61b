import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jenenliu on 2017/7/1.
 */
public class FlikTest {
    @Test
    public void TestTheSmaeNumber() {
        int a = 10;
        int b = 10;
        int c = 11;

        int i = 128;
        int j = 128;

        assertTrue(Flik.isSameNumber(a, b));
        assertFalse(Flik.isSameNumber(a, c));
        assertTrue(Flik.isSameNumber(i, j));
    }
}