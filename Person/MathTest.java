

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MathTest.
 *
 * @author  Paula Díaz Álvarez
 * @version 11/12/2022
 */
public class MathTest
{
    /**
     * Default constructor for test class MathTest
     */
    public MathTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Test for the method: computeArea(double base, double height)
     */
    @Test
    public void computeAreaBasic(){
        Math a=new Math();
        assertEquals(a.computeArea(4,2),3,0.2);
        assertEquals(a.computeArea(2,4),3,0.2);
        assertEquals(a.computeArea(1,0),0.5,0.2);
        assertEquals(a.computeArea(0,1),0.5,0.2);
        assertEquals(a.computeArea(0,0),0,0.2);
        try {
            a.computeArea(-1,0);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_BASE);
        }
        try {
            a.computeArea(-100,0);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_BASE);
        }
        try {
            a.computeArea(0,-1);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_HEIGHT);
        }
        try {
            a.computeArea(0,-100);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_HEIGHT);
        }
    }
    
    /**
     * Test for the method: isPalindrome(String text)
     */
    @Test
    public void isPalindromeBasic(){
        Math a=new Math();
        assertEquals(a.isPalindrome("Never odd or even"),true);
        assertEquals(a.isPalindrome("               E               Y               E               "),true);
        assertEquals(a.isPalindrome("Once upon a time"),false);
        assertEquals(a.isPalindrome("          M          O    U         T       H     "),false);
        try {
            a.isPalindrome(null);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NULL_STRING);
        }
    }
    
    /**
     * Test for the method: getPrimesUnder(int limit) and toString(ArrayList<Integer> list)
     */
    @Test
    public void getPrimesUnderBasic(){
        Math a=new Math();
        assertEquals(a.getPrimesUnder(0).toString(),"[]");
        assertEquals(a.getPrimesUnder(41).toString(),"[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]");
        assertEquals(a.getPrimesUnder(100).toString(),"[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]");
        try {
            a.getPrimesUnder(-1);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_LIMIT);
        }
        try {
            a.getPrimesUnder(-100);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NEGATIVE_LIMIT);
        }
        try { //if the list is null
            a.toString(null);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NULL_LIST);
        }
    }
    
    /**
     * Test for the method: sortIntArray(int[] array)
     */
    @Test
    public void sortIntArrayBasic(){
        Math a=new Math();
        assertArrayEquals(a.sortIntArray(new int[] {100, 3, 25, 7, 14}),new int[] {3, 7, 14, 25, 100});
        assertArrayEquals(a.sortIntArray(new int[] {3,2,1}),new int[] {1,2,3});
        assertArrayEquals(a.sortIntArray(new int[] {1,2,3,4,5}),new int[] {1,2,3,4,5});
        try {
            a.sortIntArray(null);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NULL_LIST);
        }
    }
    
    /**
     * Test for the method: verifyUniqueElements(int[] input)
     */
    @Test
    public void verifyUniqueElementsBasic(){
        Math a=new Math();
        assertEquals(a.verifyUniqueElements(new int[] {100, 3, 25, 7, 14}),true);
        assertEquals(a.verifyUniqueElements(new int[] {3,3,3}),false);
        assertEquals(a.verifyUniqueElements(new int[] {1,2,3,4,5}),true);
        assertEquals(a.verifyUniqueElements(new int[] {3,1,3}),false);
        try {
            a.sortIntArray(null);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_NULL_LIST);
        }
    }
    
    /**
     * Test for the method: sumMatrix(int[][] a, int[][] b)
     */
    @Test
    public void sumMatrixBasic(){
        Math a=new Math();
        int[][] c= {{1,2},{3,4}};
        int[][] d= {{1,1},{1,1}};
        assertArrayEquals(a.sumMatrix(c,d),new int[][] {{2,3},{4,5}});
        
        c= new int[][] {{1,2},{3}};
        d= new int[][] {{1,1},{1}};
        assertArrayEquals(a.sumMatrix(c,d),new int[][] {{2,3},{4}});
        try {
            c= new int[][] {{1,2},{3,4}};
            d= new int[][] {{1,1},{1}};
            a.sumMatrix(c,d);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_DIFFERENT_DIMENSION);
        }
        try {
            c= new int[][] {{1,2},{3,4}};
            d= new int[][] {{1,1}};
            a.sumMatrix(c,d);
            fail();
        }
        catch (Exception e){
            assertEquals(e.getMessage(),Math.ERROR_DIFFERENT_DIMENSION);
        }
    }
}
