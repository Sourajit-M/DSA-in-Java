/*
    *
   **
  ***
 ****    
 
 */

public class Patter_2{
    public static void main(String args[]){
        for(int i = 4; i >= 1; i--){
            for(int j=1; j <= 4;j++){
                if( j >= i )
                System.out.print("* ");
                else
                System.out.print("  ");
            }
        System.out.println();
        }

    }
}
