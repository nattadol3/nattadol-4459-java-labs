package tongbu.nattadol.lab4;

import java.util.Scanner;

/**
 * <p>This DisplayMatrix Program will ask user to enter the 2D dimension of a matrix, then ask user to input the number at each position.</p>
 * <p>After user finised.  The program will display the matrix that user have entered, then it will display the folllowing line by line in order</p>
 * <p>each values of the matrix by row, each values of the matrix by colunm, each values of the matrix by row but start backward, each values of the marix by column but backward,</p>
 * <p>values in the diagonal top left to bottom right of the matrix, values in the diagonal top right to bottom left of the matrix,</p>
 * <p>and each values of the matrix by row but zigzag (ex. if the 1st row is displayed form left to right, the 2nd will be displayed from right to left) </p>
 * 
 * @author Nattadol Tongbu
 * @version 1.0, 1/12/2023
 * ID: 653040445-9
 * Sec: 2
 */

public class DisplayMatrix {
    static int[][] matrix; // 2 dimensional array for storing a matrix.
    static int rowDim, colDim; // the number of rows and columns in the matrix.

    /**
     * <p>This is the main method.  Its will run these other methods in this order.  inputMatrix(), showMatrix(),</p>
     * <p>showMatrixByRow(), showMatrixByColumn(), showMatrixByRowBackward(), showMatrixByColumnBackward(),</p>
     * <p>showMatrixByDiagonalTopLeftBottomRight(), showMatrixByDiagonalTopRightBottomleft(), and showMatrixByRowZigzag();</p>
     * @param args is the program arguments.
     */

    public static void main(String[] args) {
        inputMatrix(); // input matrix.
        showMatrix(); // show the original matrix
        showMatrixByRow(); // show the matrix by row
        showMatrixByColumn(); // show the matrix by column
        showMatrixByRowBackward(); // show the matrix by row BackWard
        showMatrixByColumnBackward(); // show the matrix by column backward
        // show the diagonal elements of the matrix
        // from top left to bottom right
        showMatrixByDiagonalTopLeftBottomRight();
        // show the diagonal elements of the matrix
        // from top right to bottom left
        showMatrixByDiagonalTopRightBottomleft();
        // show the matrix by row zigzag
        showMatrixByRowZigzag();
    }

    /**
     * <p>inputMatrix() method ask the user to input 1. The height of the matrix 2. The width of the matrix 3. The value of each position of the matrix</p>
     * @param rowDim is to accept the user input of the matrix width.
     * @param colDim is to accept the user input of the matrix height.
     * @param matrix is the 2D array that have the width equal the value of rowDim and the height equal the value of colDim.  Then accept the values that user input to each index by row.
     */

    public static void inputMatrix() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the size of the matrix (number of rows then number of columns) : ");

        rowDim = reader.nextInt();
        colDim = reader.nextInt();
        matrix = new int[rowDim][colDim];
        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {
                System.out.print("Enter element at row " + (i + 1) + " column " + (j + 1) + " : ");
                matrix[i][j] = reader.nextInt();
            }
        }
        reader.close();
    }

    /**
     * <p>showMatrix method will display the matrix that user have input on the screen.</p>
     */

    public static void showMatrix() {
        System.out.println("Show the original matrix : ");
        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * <p>showMatrixByRow() method will display each value of matrix starting from the top row and proceed from left to right in one line.</p>
     */
    
    public static void showMatrixByRow() {
        System.out.print("Show the matrix by row : ");
        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    /**
     * <p>showMatrixByColumn() method will display each value of matrix by column starting form the first colunm and proceed from top to bottom in one line.</p>
     */

    public static void showMatrixByColumn() {
        System.out.print("Show the matrix by column : ");
        for (int i = 0; i < colDim; i++) {
            for (int j = 0; j < rowDim; j++) {
                System.out.print(matrix[j][i] + " ");
            }
        }
        System.out.println();
    }
    
    /**
     * <p>showMatrixByRowBackward() method will display each value of matrix starting from the bottom row and proceed from right to left in one line.</p>
     */

    public static void showMatrixByRowBackward() {
        System.out.print("Show the matrix by row backward : ");
        for (int i = rowDim; i > 0; i--) {
            for (int j = colDim; j > 0; j--) {
                System.out.print(matrix[i-1][j-1] + " ");
            }
        }
        System.out.println();
    }

    /**
     * <p>showMatrixByColumnBackward() method will display each value of matrix by column starting form the last colunm and proceed from bottom to top in one line.</p>
     */
    
    public static void showMatrixByColumnBackward() {
        System.out.print("Show the matrix by column backward : ");
        for (int i = colDim; i > 0; i--) {
            for (int j = rowDim; j > 0; j--) {
                System.out.print(matrix[j-1][i-1] + " ");
            }
        }
        System.out.println();
    }

    /**
     * <p>showMatrixByDiagonalTopLeftBottomRight() method will display the values that are in the diagonal line of the matrix from top left to bottom right in one line.</p>
     */

    public static void showMatrixByDiagonalTopLeftBottomRight() {
        System.out.print("Show the diagonal elements of the matrix from top-left to bottom-right : ");
        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {
                // Only print the matrix if index i == j ex. matrix[0][0], matrix[1][1], matrix[2][2]
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

    /**
     * <p>showMatrixByDiagonalTopRightBottomleft() method will display the values that are in the diagonal line of the matrix from top right to bottom left in one line.</p>
     * @param dummyColDim is to store the index value of the last column of the matrix to use in the for loop to start printing from the right most column to the left most column.
     */

    public static void showMatrixByDiagonalTopRightBottomleft() {
        System.out.print("Show the diagonal elements of the matrix from top-right to bottom-left : ");
        // dummyColDim variable that store the value of the right most column index of the matrix.
        int dummyColDim = (colDim - 1);
        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {
                // Only print the index if the colunm index == dummyColDim.  After that subtract the value of dummyColDim by 1.
                //ex. if the matrix is 3x3 matrix.  This code will only print matrix[0][2], matrix[1][1], matrix[2][0]
                if (dummyColDim == j) {
                    System.out.print(matrix[i][j] + " ");
                    dummyColDim--;
                }
            }
        }
            System.out.println();     
    }
    
    /**
     * <p>showMatrixByRowZigzag() method will display the values of the matrix by row in the zigzag order in one line.</p>
     * <p>(ex. if the 1st row is displayed form left to right, the 2nd will be displayed from right to left)</p>
     */

    public static void showMatrixByRowZigzag() {
        System.out.print("Show matrix by row zigzag : ");
        for (int i = 0; i < rowDim; i++) {
            if (i % 2 == 0) {
                // If the row is an equal number row.  Print matrix from left to right.
                for (int j = 0; j < colDim; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            else {
                for (int j = colDim; j > 0; j--) {
                    System.out.print(matrix[i][j - 1] + " ");
                }
            }
        }
        System.out.println();
    }
}
 