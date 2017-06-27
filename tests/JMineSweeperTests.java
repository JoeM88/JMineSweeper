import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by josephmolina on 6/25/17.
 */

@RunWith(Theories.class)
public class JMineSweeperTests {

    String regex = "^[0-7]\\s+[0-7]$";

    public static final String[] trueValues = new String[]{"3 3", "4 8", "6 7"};
    public static final String[] falseValues = new String[] {"10 10", "23 34", "23,4"," ", "232"};

    @Test
    public void testRegx_true(){
        String input = "3       3";
        assertTrue(input.matches(regex));
    }

    @Test
    public void testRegx_false() {
        String input = "10,10";
        assertFalse(input.matches(regex));
    }

}
