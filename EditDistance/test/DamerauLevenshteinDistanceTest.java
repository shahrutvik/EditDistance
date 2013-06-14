import gov.nih.cit.editdistance.DamerauLevenshteinDistance;
import org.junit.Test;

import static org.junit.Assert.*;

/**
* User: rshah
* Date: 6/13/13
* Time: 5:28 PM
*/
public class DamerauLevenshteinDistanceTest {
	/*
	 * Tests that same string are basically similar and hence 0 distance
	 */
    @Test
    public void testExample(){
        String testString = "asdfkljasflkwe";
        assertEquals("string should be distance 0 from itself", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(testString, testString));
    }
    
    /*
     * Test whether the method handles null
     */
    @Test
    public void testBothStringsNull(){
        String testString=null;
        try
           {
            DamerauLevenshteinDistance.computeLevenshteinDistance(testString, testString);
           }
           catch (NullPointerException npe)
           {
              return;
           }

           fail("Expected NullPointerException");
         
    }
    /*
     * Test whether the method handles null
     */
    
    @Test
    public void testSourceStringNull(){
        String testString=null;
        try
           {
            DamerauLevenshteinDistance.computeLevenshteinDistance(null, testString);
           }
           catch (NullPointerException npe)
           {
              return;
           }

           fail("Expected NullPointerException");
         
    }
    
    /*
     * Test whether the method handles null
     */
    @Test
    public void testTargetStringNull(){
        String testString=null;
        try
           {
            DamerauLevenshteinDistance.computeLevenshteinDistance(testString, testString);
           }
           catch (NullPointerException npe)
           {
              return;
           }

           fail("Expected NullPointerException");
         
    }
    /*
     * Test addition at the end calculates correct distance
     */
    @Test
    public void testAdditionAsLastCharacterDistanceCorrect(){
        String sourceString = "a";
        String targetString ="ab";
        assertEquals("string should be distance 1 with addition of 1 letter at the end", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    /*
     * Test addition at the beginning calculates correct distance
     * 
     */
    
    @Test
    public void testAdditionAsFirstCharacterCorrect(){
        String sourceString = "a";
        String targetString ="ba";
        assertEquals("string should be distance 1 with addition of 1 letter at the beginning", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testAdditionAsMiddleCharacterCorrect(){
        String sourceString = "ab";
        String targetString ="acb";
        assertEquals("string should be distance 1 with addition of 1 letter at the middle", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testDeletionAsLastCharacterDistanceCorrect(){
        String sourceString = "ab";
        String targetString ="a";
        assertEquals("string should be distance 1 with deletion of 1 letter at the end", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testDeletionAsFirstCharacterCorrect(){
        String sourceString = "ab";
        String targetString ="b";
        assertEquals("string should be distance 1 with deletion of 1 letter at the beginning", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testDeletionAsMiddleCharacterCorrect(){
        String sourceString = "acb";
        String targetString ="ab";
        assertEquals("string should be distance 1 with deletion of 1 letter at the middle", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testReplacementOfLastCharacterDistanceCorrect(){
        String sourceString = "abdef";
        String targetString ="abdeg";
        assertEquals("string should be distance 1 with replacement of 1 letter at the end", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testReplacementOfFirstCharacterCorrect(){
        String sourceString = "abqrst";
        String targetString ="mbqrst";
        assertEquals("string should be distance 1 with replacement of 1 letter at the beginning", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testReplacementOfMiddleCharacterCorrect(){
        String sourceString = "abdefg";
        String targetString ="abmefg";
        assertEquals("string should be distance 1 with replacement of 1 letter at the middle", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testTranspositionOfCharacterCorrect(){
        String sourceString = "cehgg";
        String targetString ="chegg";
        assertEquals("string should be distance 1 with transposition of 2 adjacent letters", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testReplacementOfSpecialCharacterCorrect(){
        String sourceString = "ch?egg";
        String targetString ="ch!egg";
        assertEquals("string should be distance 1 with replacement of special character", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testReplacementOfNonAsciiCharacterCorrect(){
        String sourceString = "chñegg";
        String targetString ="ch?egg";
        assertEquals("string should be distance 1 with replacement of non-ascii character", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testDistanceForSentenceCorrect(){
        String sourceString = "Today is a good day";
        String targetString ="Today is an good day";
        assertEquals("string should be distance 1 for sentence", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testEmptyStringCorrect(){
        String sourceString = "";
        String targetString ="";
        assertEquals("string should be distance 0 for empty string", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testStringToUppercaseCorrect(){
        String sourceString = "orange";
        String targetString =sourceString.toUpperCase();
        assertEquals("string should be distance 0 for same string with uppercase", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testStringToLowercaseCorrect(){
        String sourceString = "ORANGE";
        String targetString =sourceString.toLowerCase();
        assertEquals("string should be distance 0 for same string with lowercase", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testStringConcatenationCorrect(){
        String sourceString = "Orange Apple";
        String targetString ="OrangeApple";
        assertEquals("string should be distance 1 for same string with concatenation", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testStringOnlySpaceCorrect(){
        String sourceString = " ";
        String targetString =" ";
        assertEquals("string should be distance 0 for same string with only spaces", 0, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
    }
    
    @Test
    public void testStringMultipleChangesCorrect(){
        String sourceString = "ab";
        String targetString ="abc";
        assertEquals("string should be distance 1 for addition of characters", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
        String delString="bc";
        assertEquals("string should be distance 1 for deletion of characters", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(targetString, delString));
        String replaceString="bd";
        assertEquals("string should be distance 1 for replacement of characters", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(delString, replaceString));
        String transposedString="db";
        assertEquals("string should be distance 1 for transposing of characters", 1, DamerauLevenshteinDistance.computeLevenshteinDistance(replaceString, transposedString));
    }
    
    @Test
    public void testLongDistanceCorrect(){
        String sourceString = "abcdefghijklmnopqrstuvwxyz";
        String targetString ="zyxwvutsrqponmlkjihgfedcba";
        assertEquals("string should be distance 26 for long sentence", 26, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
        
    }
    
    @Test
    public void testReverseStringDistanceCorrect(){
        String sourceString = "hello world";
        String targetString =reverseString(sourceString);
        assertEquals("string should be distance 8 for reversed string", 8, DamerauLevenshteinDistance.computeLevenshteinDistance(sourceString, targetString));
        
    }
    
    
    private String reverseString(String original){
    	
    	String reversedString=null;
    	for (String part : original.split(" ")) {
    	    reversedString= new StringBuffer(part).reverse().toString();
    	    
    	}
    	return reversedString;
    }
    
    
     
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    

}