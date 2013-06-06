import gov.nih.cit.editdistance.DamerauLevenshteinDistance;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: bbercovitz@chegg.com
 * Date: 6/3/13
 * Time: 5:28 PM
 */
public class DamerauLevenshteinDistanceTest {
    @Test
    public void testExample(){
        String testString = "asdfkljasflkwe";
        assertEquals("string should be distance 0 from itself", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(testString, testString));
    }

}
