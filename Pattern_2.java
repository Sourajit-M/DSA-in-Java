public class Pattern_2{
        public static void Butterfly_Pattern(int n){
        int i,j,k;
       for(i=1; i<=n ;i++){
        for(j=1; j<=n ;j++){
            if(j <= i){
          System.out.print("* ");
            }
          else{
          System.out.print("  ");
          }
        }
        for(k=1; k<=n; k++){
            if(k >= n-i+1){
            System.out.print("* ");
            }
            else{
            System.out.print("  ");
            }
        }
        System.out.println();
       }
       for(i=n ; i>=1; i--){
        for( j=1; j<=n; j++){
            if(j <= i){
            System.out.print("* ");
            }
            else{
            System.out.print("  ");
            }
        }
        for(k=n; k>=1; k--){
            if( k <=i){
            System.out.print("* ");
            }
            else{
            System.out.print("  ");
            }
        }
        System.out.println();
       }
      }
      public static void inverted_pyramid(int n){
        for(int i =n;i >= 1; i--){
            for(int j =1;j <= i; j++){
                System.out.print(j+ " ");
            }
        System.out.println();
        }
      }
      public static void Border_elements(int n){
        int i,j;
    for(i = 1;i <= n; i++){
        for( j = 1; j <= n; j++){
            if(i == 1 || i == n){
            System.out.print("* ");
        }
           else if(j==1 || j==n){
            System.out.print("* ");
           }
           else 
           System.out.print("  ");
        }
        System.out.println();
    }
      }
      public static void solid_rhombus(int n){
        for(int i=1; i<=n; i++){
            //space
            for(int j=1; j <=n-i; j++){
             System.out.print(" ");
            }
            for(int k=1; k<=n; k++){
            System.out.print("*");
            }
            System.out.println();
        }
    }
        public static void hollow_rhombus(int n){
          for(int i=1; i<=n; i++){
            //space
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=n; k++){
                if(k==1 || k==n || i==1 || i==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
          }  
        }
        
        public static void diamond(int n){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n-i;j++){
                    System.out.print(" ");
                }
                for(int k=1; k<= 2*i-1; k++){
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i=n;i>=1;i--){
                for(int j=n;j>=n-i;j--){
                    System.out.print(" ");
                }
                for(int k=1; k<= 2*i-1; k++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
      
       public static void main(String args[]){
        //obj.solid_rhombus(5);
        diamond(5);
    }
}
