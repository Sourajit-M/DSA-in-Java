
public class SpiralMatrix {
    public static void spiralMat(int mat[][]){
        int startRow = 0;
        int endRow = mat.length-1;
        int startCol = 0;
        int endCol = mat[0].length;

        while(startRow <= endRow && startCol <= endCol){
            if(startRow == startCol || endRow == endCol)
            return;
            //top
            for(int j=0; j<=endCol; j++){
                System.out.print(mat[startRow][j]+ " ");
            }
            //right
            for(int i = startRow+1; i<= endRow; i++){
                System.out.print(mat[i][endCol]+ " ");
            }
            // bottom
            for(int j = endCol-1; j>=startCol; j--){
                System.out.print(mat[endRow][j]+ " ");
            }
            //left
            for(int i = endRow-1; i>=startRow+1; i--){
                System.out.print(mat[i][startCol]);
            }
            System.out.println();
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }
    public static void main(String args[]){
        int mat[][]={{1, 2, 3},
                     {4,5,6},
                    {7,8,9}};
                     
     spiralMat(mat);         
    }
}
