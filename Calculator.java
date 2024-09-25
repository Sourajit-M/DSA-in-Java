
//MAGIC CALCULATOR


import java.util.*;
public class Calculator {
double calc (double num1, double num2, char o){
    double val = 0.0;
        switch(o){
        case '+':
        val = (num1+num2);
        break;   
        case '-':
        val = (num1-num2);
        break;
        case '/':
        val = (num1/num2);
        break;
        case '%':
        val = (num1%num2);
        break;
        case '*':
        val = (num1*num2);
    }
    return val;
}
    public static void main(String args[]){
    Calculator obj = new Calculator();
    boolean run = true;
    double prev = 0.0;
    try (Scanner sc = new Scanner(System.in)) {
        while(run){
            if(prev == 0.0){
            System.out.println("Enter number:");
            double n1 = sc.nextDouble();
            System.out.println("Enter a operator +, -, %, /, *");
            char op  = sc.next().charAt(0);
            System.out.println("Enter number:");
            double n2 = sc.nextDouble();
            prev = obj.calc(n1,n2,op);
            System.out.println("RESULT="+prev);
        }
        else{
            System.out.println("Current Result:"+prev);
            System.out.println("Enter a operator +, -, %, /");
            char op1  = sc.next().charAt(0);
            System.out.println("Enter number");
            double var = sc.nextInt();
            prev = obj.calc(prev,var,op1);
            System.out.println("RESULT="+prev);
        }
        System.out.println("TO QUIT PRESS 1");
        System.out.println("ELSE TO CONTINUE PRESS 2");
        int  k = sc.nextInt();
        switch(k)
        {
            case 1:
            System.out.println("GOODBYE!!");
            run = false;
            break;
            case 2:
            run = true;
            break;
            default :
            System.out.println("YOU ARE CONSIDERED TO CONTINUE");
        }
}
    }
}
}
