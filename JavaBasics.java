import java.util.*;

public class JavaBasics {
    public static void main(String args[]){
    try (Scanner sc = new Scanner(System.in)) {
        System.out.println("Enter any year to check whether it is leap year");
        int year = sc.nextInt();
        if( year % 4 == 0){
            if( year % 100 == 0){
                if( year % 400 == 0){
                    System.out.println("Leap Year:"+year);
                }
                else{
                    System.out.println("Not leap year:"+year);
                }
              }
                else{
                    System.out.println("Leap year:"+year);
                }
        }
        else {
            System.out.println("Not a leap year:"+year);
        }
    }
    
        }
    }


