public class Backtracking_2 {

    public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i==n-1 && j==m-1){
            return 1;
        }
        else if(i==n || j==m){
            return 0;
        }
        //down choice
        int w1 = gridWays(i+1, j, n, m);
        // right choice
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<sudoku.length; i++){
           for(int j=0; j<sudoku.length; j++){
            System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
           }
    }

    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //row
        int i, j;
        for(i =0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //column
        for(j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //grid
        int start_row = (row/3)*3;
        int start_col = (col/3)*3;
        for(i=start_row; i<start_row+3; i++){
           for(j=start_col; j<start_col+3; j++){
            if(sudoku[i][j] == digit){
                return false;
            }
           }
        }
        return true;
    }

    public static boolean SudokuSolver(int sudoku[][], int row, int col){
       //base case
       if(row == 9){
        return true;
       }

       int next_row = row, next_col=col+1;
       
       if(col+1 == 9){
        next_row = row + 1;
        next_col = 0;
       }

       if(sudoku[row][col] != 0){
        return SudokuSolver(sudoku, next_row, next_col);
       }
       
       for(int digit=1; digit<=9;digit++){
        if(isSafe(sudoku, row, col, digit)){
             sudoku[row][col] = digit;   
            if(SudokuSolver(sudoku, next_row, next_col)){
                return true;
            }
            sudoku[row][col] = 0;
        }
       }
       return false;
    }

    public static void main(String args[]){
    // int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
    //                 {4, 9 ,0, 1, 5, 7, 0, 0, 2},
    //                 {0, 0 , 3, 0, 0, 4, 1, 9, 0},
    //                 {1, 8, 5, 0, 6, 0, 0, 2, 0},
    //                 {0, 0, 0, 0, 2, 0 , 0, 6, 0},
    //                 {9, 6, 0, 4, 0, 5, 3, 0, 0},
    //                 {0, 3, 0, 0, 7, 2, 0, 0, 4},
    //                 {0, 4, 9, 0, 3, 0, 0, 5, 7},
    //                 {8, 2, 7, 0, 0, 9, 0, 1, 3}};

    int sudoku[][] = {{8,3,0,0,7,0,0,0,0}
    ,{6,0,0,1,9,5,0,0,0}
    ,{0,9,8,0,0,0,0,6,0}
    ,{8,0,0,0,6,0,0,0,3}
    ,{4,0,0,8,0,3,0,0,1}
    ,{7,0,0,0,2,0,0,0,6}
    ,{0,6,0,0,0,0,2,8,0}
    ,{0,0,0,4,1,9,0,0,5}
    ,{0,0,0,0,8,0,0,7,9}};
                
            System.out.println("*****SUDOKU******");
            printSudoku(sudoku);    
       
             if(SudokuSolver(sudoku, 0, 0) == true){
                System.out.println("Solution exists:");
                printSudoku(sudoku);            
        }
        else{
            System.out.println("Solution doesn't exist");
        }
   }
}
