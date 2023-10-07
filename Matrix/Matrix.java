import java.util.*;

/**
 * The Matrix class allows to do several operations with matrices.
 *
 * @author Paula Díaz Álvarez
 * @version 28/11/2022
 */
public class Matrix
{
    // Error messages
    /**
     * Error message that will be thrown if the user introduces a matrix with dimension greater than 20
     */
    public final static String ERROR_WRONG_DIMENSION="Invalid dimension for the matrix";
    /**
     * Error message that will be thrown if the user introduces a matrix that is not squared
     */
    public final static String ERROR_NOT_SQUARED="The matrix must be square";
    /**
     * Error message that will be thrown if the user introduces a number for the column that is negative or its higher than the width of the matrix
     */
    public final static String ERROR_WRONG_COLUMN="Column value is incorrect"; 
    // Attributes
    private int[][] matrix;
    
    //CONSTRUCTORS
    /**
     * Constructor for creating a squared matrix of a given dimension filled with random integers between 0 and 255.
     * If the given dimension is less than or equal to 0, or higher than 20, an error message will appear
     * @param dimension It's the dimension for the matrix that is going to be created
     */
    public Matrix(int dimension) {
        checkParam(dimension>0 && dimension<=20,ERROR_WRONG_DIMENSION);
        Random coin=new Random();
        matrix= new int[dimension][dimension];
        
        for (int i=0; i<dimension ; i++){
            for (int j=0; j<dimension ; j++){
                matrix[i][j]=coin.nextInt(256);
            }
        }
    }
    
    /**
     * Constructor for creating a copy of a given matrix.
     * If the given matrix is not square, an error message will appear. If the dimension of the given matrix is less than or equal to 0
     * or higher than 20, another error message will appear
     * @param matrix Corresponds to the given matrix
     */
    public Matrix(int[][] matrix) {
        checkParam(matrix!=null && matrix.length>0 && matrix.length<=20,ERROR_WRONG_DIMENSION);
        for (int[] row : matrix){
            checkParam(matrix[0].length==row.length,ERROR_NOT_SQUARED);
        }
        this.matrix=new int[matrix.length][matrix.length];
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix.length ; j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }
    }
    //checkParam
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the condition that is going to be checked
     * @param message It's the error message that is going to be thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message) {
        if (!condition)
            throw new RuntimeException (message);
    }
    //Exercises
    /**
     * Returns a copy of the matrix.
     * @return A copy of the matrix
     */
    public int[][] getMatrix() {
        int[][] copy=new int[matrix.length][matrix.length];
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix.length ; j++){
                copy[i][j]=matrix[i][j];
            }
        }
        return copy;
    }
    
    /**
     * Returns the content of the matrix “flattened” (returns the content of the matrix in one row)
     * @return The content of the matrix in one row
     */
    public ArrayList<Integer> flattenMatrix(){
        ArrayList<Integer> flattened=new ArrayList<Integer>(matrix.length*matrix.length);
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix.length ; j++){
                flattened.add(matrix[i][j]);
            }
        }
        return flattened;
    }
    
    /**
     * Interchanges the elements of the two diagonals of the matrix
     */
    public void swapReveseByDiagonals() {
        int[] leadingDiagonal= new int[matrix.length]; //up-down (left-right)
        int[] laggingDiagonal= new int[matrix.length]; //down-up (left-right)
        
        for (int i=0; i<matrix.length ; i++){
            //copying the values
            leadingDiagonal[i]=matrix[i][i];
            laggingDiagonal[i]=matrix[matrix.length-1-i][i];
            //swapping the diagonals
            matrix[i][i]=laggingDiagonal[i];
            matrix[matrix.length-1-i][i]=leadingDiagonal[i];
        }
    }
    
    /**
     * Move the elements of the given column to the last column of the matrix, moving the rest of the columns one position to
     * the left. 
     * If the number of column is not valid, an error message will appear
     * @param column It's the number of the column that you want to move
     */
    public void moveColumn(int column){
        checkParam(column>=0 && column<matrix.length,ERROR_WRONG_COLUMN);
        int[] col= new int[matrix.length];
        for (int i=0; i<matrix.length ; i++){
            col[i]=matrix[i][column]; //copying the column we want to move
            for (int j=column; j<matrix.length-1 ; j++){
                matrix[i][j]=matrix[i][j+1]; //move one position to the left
            }
            matrix[i][matrix.length-1]=col[i]; //moving the column we want to move
        }
    }
    
    /**
     * Prints the content of the matrix in a matrix format
     */
    public void print() {
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix.length ; j++){
                if (matrix[i][j]>=100){ //3 digits
                    System.out.print(matrix[i][j]+" ");
                }
                else if (matrix[i][j]>=10){ //2 digits
                    System.out.print(" "+matrix[i][j]+" ");
                }
                else { //1 digit
                    System.out.print(" "+matrix[i][j]+"  ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Replace as many elements of the matrix as possible with the elements of the flatMatrix
     * @param flatMatrix It's the matrix that replaces the elements of the other one
     * @return The number of elements replaced
     */
    public int replaceMatrix(ArrayList<Integer>flatMatrix){
        checkParam(flatMatrix!=null,ERROR_WRONG_DIMENSION);
        int counter=0;
        for (int i=0; i<matrix.length && flatMatrix.size()>0 ; i++){
            for (int j=0; j<matrix.length && flatMatrix.size()>0 ; j++){
                matrix[i][j]=flatMatrix.get(0); //changing the element
                flatMatrix.remove(0); //so the value that is used to replace the elements is always in position 0
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Returns a matrix where each element corresponds with the average of its neighbours (excluding the element itself)
     * of the original matrix
     * @return The matrix that has as elements the average of the neighbours
     */
    public int [][] smoothMatrix(){
        int[][] average=new int[matrix.length][matrix.length];
        //magic
        for (int i=0; i<matrix.length ; i++){
            for (int j=0; j<matrix.length ; j++){
                int sum=0;
                int counter=0;
                //I use 2 for loops to check the neighbours of the element [i][j]
                for (int k=i-1; k<=i+1 ; k++){
                    if (k<0){ 
                        continue; //if the row is out of the matrix from above, we skip to the next row
                    }
                    if (k>=matrix.length){ 
                        break; //if the row is out of the matrix from below, the for ends because there aren't more rows
                    }
                    for (int l=j-1; l<=j+1 ; l++){
                        if (l<0 || (k==i && l==j)){ 
                            continue;   //if the column is out of the matrix from the left or we are in the element [i][j],           
                        }               //we skip to the next column
                        if (l>=matrix.length){
                            break; //if the column is out of the matrix from the right, the for ends because there aren't more columns
                        }
                        sum+=matrix[k][l]; //we sum the neighbours
                        counter++; //and count how many neighbours has
                    }
                }
                average[i][j]=sum/counter; //calculate the average after checking all the neighbours
            }
        }
        return average;
    }
}
