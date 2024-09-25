import java.util.*;
public class Backtracking {
    public static void findSubsets(String str, int i, String ans){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
            System.out.println(ans);
            }
            return;
        }
        // Yes choice
        findSubsets(str, i+1, ans+str.charAt(i));
        // No choice
        findSubsets(str, i+1, ans);
    }

    public static void findPermutation(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0;i < str.length();i++){
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(NewStr, ans+curr);
        }
    }

    public static boolean isSafeKnights(char board[][], int row, int col){
        //left up
        for(int i=row-2,j=col-1; i>=0 && j>=0; i=i-2,j--){
           if(board[i][j] == 'K'){
            return false;
           }
        }
        //right up
        for(int i=row-2, j=col+1; i>=0 && j<board.length; i=i-2,j++){
           if(board[i][j] == 'K'){
            return false;
           }
        }
        // sideways left
        for(int i=row-1,j=col-2; i>=0 && j>=0; i=i--,j=j-2){
           if(board[i][j] == 'K'){
            return false;
           }
        }
        //sideways right 
        for(int i=row+1,j=col-2; i<board.length && j>=0; i++,j=j-2){
           if(board[i][j] == 'K'){
            return false;
           }
        }
        return true;
    }

    public static boolean isSafeQueens(char board[][], int row, int col){
        //vertical up
        for(int i=row-1; i>=0; i--){
           if(board[i][col] == 'Q'){
            return false;
           }
        }
        //diagonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
           if(board[i][j] == 'Q'){
            return false;
           }
        }
        //diagonal right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
           if(board[i][j] == 'Q'){
            return false;
           }
        }
        return true;
    }

    public static void nKnights(char board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            return;
        }
        // column loop 
        for(int j=0; j<board.length; j++){
            if(isSafeKnights(board, row, j)){
            board[row][j] = 'K';
            nKnights(board, row+1);
            board[row][j] = 'x'; //backtracking step
        }
    }
}

    public static void nQueens(char board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            return;
        }
        // column loop 
        for(int j=0; j<board.length; j++){
            if(isSafeQueens(board, row, j)){
            board[row][j] = 'Q';
            nQueens(board, row+1);
            board[row][j] = 'x'; //backtracking step
        }
    }
}


    public static void printBoard(char board[][]){

        System.out.println("*******Chess Board*******");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        //findSubsets(str, 0, "");
       // findPermutation(str, "");
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter the number of rows: ");
       int N = sc.nextInt();
       char board[][] = new char[N][N];
       //initilization
       for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
               board[i][j] = 'x';
            }
            System.out.println();
        }

        if(board.length<4){
            System.out.println("No possibilities available");
            return;
        }

        nQueens(board, 0);
    }
}
