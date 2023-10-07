

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class MatrixTest.
 *
 * @author  Paula Díaz Álvarez
 * @version 29/11/2022
 */
public class MatrixTest
{
    /**
     * Default constructor for test class MatrixTest
     */
    public MatrixTest()
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
     * Test for the constructor: Matrix(int[][] matrix)
     */
    @Test
    public void constructorArrayBasic(){
        int[][] matrix1=new int[1][1];
        int[][] matrix2=new int[10][10];
        int[][] matrix3=new int[20][20];
        int[][] matrix4={{1,2},{3,4}};
        //for negative test
        int[][] matrix5= new int[21][21];
        int[][] matrix6= new int[40][40];
        int[][] matrix7={{1,2,3},{4,5,6},{7,8}};
        int[][] matrix8={{1},{5,6},{9},{13,14}};
        int[][] matrix9=null;
        int[][] matrix10=new int[0][0];
        
        Matrix a=new Matrix(matrix1);
        assertArrayEquals(a.getMatrix(),matrix1);
        
        a=new Matrix(matrix2);
        assertArrayEquals(a.getMatrix(),matrix2);
        
        a=new Matrix(matrix3);
        assertArrayEquals(a.getMatrix(),matrix3);
        
        a=new Matrix(matrix4);
        assertArrayEquals(a.getMatrix(),matrix4);
        try{ //dimension above 20
            a=new Matrix(matrix5);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_DIMENSION);
        }
        try{ //dimension above 20
            a=new Matrix(matrix6);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_DIMENSION);
        }
        try{ //dimension 0
            a=new Matrix(matrix10);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_DIMENSION);
        }
        
        try{ //null matrix
            a=new Matrix(matrix9);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_DIMENSION);
        }
        
        try{ //not squared matrix
            a=new Matrix(matrix7);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_NOT_SQUARED);
        }
        try{ //not squared matrix
            a=new Matrix(matrix8);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix4);
            assertEquals(e.getMessage(),Matrix.ERROR_NOT_SQUARED);
        }
    }
    
    /**
     * Test for the method: flattenMatrix
     */
    @Test
    public void flattenMatrixBasic(){
        int[][] matrix1={{1,2},{3,4}};
        ArrayList<Integer> list1=new ArrayList<Integer>();
        for(int i=1 ; i<=4; i++){
            list1.add(i);
        }
        
        int[][] matrix2={{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list2=new ArrayList<Integer>();
        for(int i=1 ; i<=9; i++){
            list2.add(i);
        }
        
        int[][] matrix3={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list3=new ArrayList<Integer>();
        for(int i=1 ; i<=16; i++){
            list3.add(i);
        }
        
        Matrix a=new Matrix(matrix1);
        assertEquals(a.flattenMatrix(),list1);
        
        a=new Matrix(matrix2);
        assertEquals(a.flattenMatrix(),list2);
        
        a=new Matrix(matrix3);
        assertEquals(a.flattenMatrix(),list3);
    }
    
    /**
     * Test for the method: swapReveseByDiagonals
     */
    @Test
    public void swapReverseByDiagonalsBasic(){
        int[][] matrix1={{1,2},{3,4}};
        int[][] reverse1={{3,4},{1,2}};
        
        int[][] matrix2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] reverse2={{7,2,9},{4,5,6},{1,8,3}};
        
        int[][] matrix3={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] reverse3={{13,2,3,16},{5,10,11,8},{9,6,7,12},{1,14,15,4}};
        
        int[][] matrix4={{5,10,3,9},{16,30,25,41},{2,17,50,12},{45,8,22,34}};
        int[][] reverse4={{45,10,3,34},{16,17,50,41},{2,30,25,12},{5,8,22,9}};
        
        Matrix a=new Matrix(matrix1);
        a.swapReveseByDiagonals();
        assertArrayEquals(a.getMatrix(),reverse1);
        
        a=new Matrix(matrix2);
        a.swapReveseByDiagonals();
        assertArrayEquals(a.getMatrix(),reverse2);
        
        a=new Matrix(matrix3);
        a.swapReveseByDiagonals();
        assertArrayEquals(a.getMatrix(),reverse3);
        
        a=new Matrix(matrix4);
        a.swapReveseByDiagonals();
        assertArrayEquals(a.getMatrix(),reverse4);
    }
    
    /**
     * Test for the method: moveColumn
     */
    @Test
    public void moveColumnBasic(){
        int[][] matrix1={{1,2},{3,4}};
        int[][] moved1={{2,1},{4,3}};
        
        int[][] matrix2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] moved2={{1,3,2},{4,6,5},{7,9,8}};
        
        int[][] matrix3={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] moved3={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        Matrix a=new Matrix(matrix1);
        a.moveColumn(0); //move the first column
        assertArrayEquals(a.getMatrix(),moved1);
        
        a=new Matrix(matrix2);
        a.moveColumn(matrix2.length/2); //move the column in the middle
        assertArrayEquals(a.getMatrix(),moved2);
        
        a=new Matrix(matrix3);
        a.moveColumn(matrix3.length-1); //move the last column
        assertArrayEquals(a.getMatrix(),moved3);
        
        a=new Matrix(matrix1);
        try{ //column=-1
            a.moveColumn(-1);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix1);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_COLUMN);
        }
        try{ //column=-10
            a.moveColumn(-10);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix1);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_COLUMN);
        }
        
        try{ //column=3
            a.moveColumn(matrix1.length);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix1);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_COLUMN);
        }
        try{ //column=10
            a.moveColumn(10);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix1);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_COLUMN);
        }
    }
    
    /**
     * Test for the method: replaceMatrix
     */
    @Test
    public void replaceMatrixBasic(){
        int[][] matrix1={{1,2},{3,4}};
        ArrayList<Integer> list1=new ArrayList<Integer>();
        
        int[][] matrix2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] replaced2={{0,0,0},{0,5,6},{7,8,9}};
        ArrayList<Integer> list2=new ArrayList<Integer>();
        for(int i=0 ; i<matrix2.length*matrix2[0].length /2; i++){ //with half zeros
            list2.add(0);
        }

        int[][] matrix3={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] replaced3={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        ArrayList<Integer> list3=new ArrayList<Integer>();
        for(int i=0 ; i<matrix3.length*matrix3[0].length +4; i++){ //even more zeros than the length of matrix 3
            list3.add(0);
        }
        
        Matrix a=new Matrix(matrix1);
        assertEquals(a.replaceMatrix(list1),0);
        assertArrayEquals(a.getMatrix(),matrix1);
        
        a=new Matrix(matrix2);
        assertEquals(a.replaceMatrix(list2),matrix2.length*matrix2[0].length/2);
        assertArrayEquals(a.getMatrix(),replaced2);
        
        a=new Matrix(matrix3);
        assertEquals(a.replaceMatrix(list3),matrix3.length*matrix3[0].length);
        assertArrayEquals(a.getMatrix(),replaced3);
        
        a=new Matrix(matrix3);
        ArrayList<Integer> list4= null;
        try{ //null matrix
            a.replaceMatrix(list4);
            fail();
        }
        catch (Exception e){
            assertArrayEquals(a.getMatrix(),matrix3);
            assertEquals(e.getMessage(),Matrix.ERROR_WRONG_DIMENSION);
        }
    }
    
    /**
     * Test for the method: smoothMatrix
     */
    @Test
    public void smoothMatrixBasic(){
        int[][] matrix1={{1,2},{3,4}};
        int[][] average1={{3,2},{2,2}};
        
        int[][] matrix2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] average2={{3,3,4},{4,5,5},{5,6,6}};
        
        int[][] matrix3={{5,10,3,9},{16,30,25,41},{2,17,50,12},{45,8,22,34}};
        int[][] average3={{18,15,23,23},{12,16,21,19},{23,24,23,34},{9,27,24,28}};

        Matrix a=new Matrix(matrix1);
        assertArrayEquals(a.smoothMatrix(),average1);
        
        a=new Matrix(matrix2);
        assertArrayEquals(a.smoothMatrix(),average2);
        
        a=new Matrix(matrix3);
        assertArrayEquals(a.smoothMatrix(),average3);
    }
}
