import java.util.*;

/**
 * Generic class to perform mathematical operations.
 * 
 * @Paula Díaz Álvarez
 * @version 2022/9/16
 */
public class Math
{
    /**
     * It's the error message that will be thrown if the user tries to introduce a negative base
     */
    public final static String ERROR_NEGATIVE_BASE="The base must be positive";
    /**
     * It's the error message that will be thrown if the user tries to introduce a negative height
     */
    public final static String ERROR_NEGATIVE_HEIGHT="The height must be positive";
    /**
     * It's the error message that will be thrown if the user tries to introduce a null string
     */
    public final static String ERROR_NULL_STRING="The text must be different from null";
    /**
     * It's the error message that will be thrown if the user tries to introduce a negative limit
     */
    public final static String ERROR_NEGATIVE_LIMIT="The limit must be positive";
    /**
     * It's the error message that will be thrown if the user tries to introduce a null list
     */
    public final static String ERROR_NULL_LIST="The list must be different from null";
    /**
     * It's the error message that will be thrown if the user tries to introduce a negative number of rows
     */
    public final static String ERROR_NEGATIVE_ROW="The number of rows must be positive";
    /**
     * It's the error message that will be thrown if the user tries to introduce a negative number of columns
     */
    public final static String ERROR_NEGATIVE_COL="The number of columns must be positive";
    /**
     * It's the error message that will be thrown if the matrices have different dimension
     */
    public final static String ERROR_DIFFERENT_DIMENSION="The dimension of the matrices is different";
    
    /**
     * Constructor for objects of class Math
     */
    public Math()
    {
        
    }
    
    //EXCEPTIONS
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the condition that is going to be checked
     * @param message It's the error message that is thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message) {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    /**
     * Computes the area of a triangle from a given base and given height.
     * Measurements are given in metric systems.
     * @param base It's the base of the triangle. This value must be 0 or higher
     * @param height It's the height of the triangle. This value must be 0 or higher
     * @return The area of the triangle in squared units.
     */
    public double computeArea (double base, double height) {
        checkParam(base>=0, ERROR_NEGATIVE_BASE);
        checkParam(height>=0, ERROR_NEGATIVE_HEIGHT);
        return (base+height) / 2;
    }
    
    /**
     * Checks if the text is a Palindrome (it's the same reading the text from left to right and reading it from right to left)
     * Blanks are not consider. If the text is nulll, an error message will appear.
     * @param text It's the text that is going to be checked
     * @return True if the test is a Palindrome
     */
    public boolean isPalindrome(String text){
        checkParam(text!=null, ERROR_NULL_STRING);
        String[] words= text.toLowerCase().split(" ");
        String letters="";
        for (int i=0; i<words.length ; i++){
            for (int j=0; j<words[i].length(); j++){
                letters+=words[i].charAt(j);
            }
        }
        boolean palindrome=true;
        for (int i=0; i<letters.length(); i++){
            if (i>=letters.length()-1-i){ //the chars has been checked already, so we can stop
                break;
            }
            if (letters.charAt(i)!=letters.charAt(letters.length()-1-i)){
                palindrome=false;
                break;
            }
        } 
        return palindrome;
        /*
         * int i=0:
         * int j= text.length()-1
         * text.toUpperCase();
         * while(i<j) {
         *     while(text.chartAR(i)==' ')
         *      i++
         *     while(text.chartAR(i)==' ')
         *      j--
         *     if (text.charAt(i)!= text[j]) //we are on a valid char
         *      return false;
         *     i++
         *     j--
         * }
         * return true;
         */
    }
    
    /**
     * Returns a list containing the prime numbers lower than the given limit (included). If the limit is negative, an error message will appear
     * @param limit It's the upper limit for calculating the primes
     * @return A list containing the prime numbers lower than given limit
     */
    public ArrayList<Integer> getPrimesUnder(int limit){
        checkParam(limit>=0, ERROR_NEGATIVE_LIMIT);
        ///take the numbers as the positions of the list
        ArrayList<Boolean> numbers= new ArrayList<Boolean>();
        ArrayList<Integer> primes= new ArrayList<Integer>();
        for (int i=0; i<=limit ; i++){
            numbers.add(true); //suppose all the numbers are prime
            if (i==0 || i==1){
                numbers.set(i,false); //0 and 1 are not primes
            }
        }
        for (int i=2; i<=limit ; i++){ //start at 2
            if(numbers.get(i)==true){ //if it's a prime
                for (int j=i; j<=limit; j+=i){
                    numbers.set(j,false); //set to false all its multiples
                }
                primes.add(i); //add the prime
            }
        }
        return primes;
    }
    /*
     * private boolean isPrime(int candidate){
     *     for (int i=2; i<candidate/2; i++){
     *         if(candidate%i==0){
     *             return false;
     *         }
     *     }
     *     return true;
     * }
     */
    
    /**
     * Returns a string from a given list. If the list is null an error message will appear
     * @param list It's the given list to convert to a String
     * @return A string from a given list
     */
    public String toString(ArrayList<Integer> list){
        checkParam(list!=null, ERROR_NULL_LIST);
        String aux="[";
        for(int i=0; i<list.size() ; i++){
            aux+=list.get(i);
            if (i!=list.size()-1){
                aux+=", ";
            }
        }
        aux+="]";
        return aux;
    }
    
    /**
     * Returns a list containing the numbers of the given limit sorted in ascending order. If the list is null, an error message will appear
     * @param array It's the given list containing the numbers
     * @return A list containing the of the given limit sorted in ascending order
     */
    public int[] sortIntArray(int[] array){
        checkParam(array!=null, ERROR_NULL_LIST);
        int[] sorted= new int[array.length];
        for (int i=0 ; i<array.length; i++){
            int min=array[i];
            int pos=i;
            for (int j=i ; j<array.length; j++){
                if (array[j]<min){
                    min=array[j];
                    pos=j;
                }
            }
            array[pos]=array[i];
            array[i]=min;
        }
        return array;
    }
    
    /**
     * Returns a matrix filled with non repeated random values for the given dimensions
     * @param row It's the amount of rows that will have the matrix
     * @param col It's the amount of columns that will have the matrix
     * @return The matrix filled with non repeates random values
     */
    public int[][] randomMatrix(int row, int col){
        checkParam(row>=0,ERROR_NEGATIVE_ROW);
        checkParam(col>=0,ERROR_NEGATIVE_COL);
        int[][] matrix= new int[row][col];
        ArrayList<Integer> elements= new ArrayList<Integer>();
        for (int i=0 ; i<row*col ; i++){
            elements.add(i);
        }
        //ArrayList<Integer> elements= new ArrayList<Integer>(); //to store the elements already used
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix[i].length ; j++){
                int pos= new Random().nextInt(elements.size());
                int a= elements.get(pos);
                matrix[i][j]=a;
                elements.remove(pos);
                /*
                while(matrix[i][j] == 0){ //the default value
                    if (!elements.contains(a)){
                        elements.add(a); //add it to the elements used
                        matrix[i][j]=a;
                    }
                }*/
            }
        }
        return matrix;
    }
    
    /**
     * Checks if a given list is filled with non repeated values
     * @param input It's the given list that it's going to be checked
     * @return True if the list has unique elements
     */
    public boolean verifyUniqueElements(int[] input){
        checkParam(input!=null,ERROR_NULL_LIST);
        ArrayList<Integer> elements= new ArrayList<Integer>();
        for (int i=0; i<input.length ; i++){
            if (!elements.contains(input[i])){
                elements.add(input[i]);
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returs the sum of 2 given matrices. If the dimension of the matrices is different, an error message will appear
     * @param a It's one of the given matrices
     * @param b It's other given matrix
     * @return The sum of the 2 matrices
     */
    public int[][] sumMatrix(int[][] a, int[][] b){
        checkParam(a.length==b.length,ERROR_DIFFERENT_DIMENSION);
        int[][] sum= new int[a.length][];
        for (int i=0; i<a.length; i++){
            checkParam(a[i].length==b[i].length,ERROR_DIFFERENT_DIMENSION);
            sum[i]=new int[a[i].length];
        }
        
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[i].length; j++){
                sum[i][j]=a[i][j]+b[i][j];
            }
        }
        return sum;
    }
}
