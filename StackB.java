import java.util.*;
public class StackB {

    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
           s.push(data);
           return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            sb.append(curr);
        }
        System.out.println(sb.toString());
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
           return;
        }
        int val = s.pop();
        reverseStack(s);
        pushAtBottom(s, val);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void stockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<span.length; i++){
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void nextGreater(){
        int ar[] = {6, 8, 0, 1, 3};
    int nextGreater[] = new int[ar.length];
    Stack<Integer> s = new Stack<>();
    for(int i=ar.length-1; i>=0; i--){

        while(!s.isEmpty() && ar[s.peek()]<=ar[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nextGreater[i] = -1;
        }
        else{
            nextGreater[i] = ar[s.peek()];
        }
        s.push(i);
    }

    for(int i=0; i<nextGreater.length; i++){
        System.out.println(nextGreater[i]);
    }
    }
    
    public static boolean isValid(String str){
      Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch =str.charAt(i);
            
            //opening bracket
            if(ch=='[' || ch=='{' || ch=='('){
                s.push(ch);
            }

            //closing bracket
            else{
                if(s.isEmpty()){
                    return false;
                }
                
                if( (ch==']' && s.peek()=='[')
                ||(ch=='}' && s.peek()=='{') 
                || (ch==')' && s.peek()=='(') ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            //closing 
            if(ch == ')'){
              int count=0;
              while(s.peek() != '('){
                s.pop();
                count++;
              } 
              if(count < 1){//duplicate found
                return true;
              }
              s.pop();
            }
            else{
                s.push(ch);
            }
        }
            if(s.isEmpty()){
                return false;
            }
            else{
                return true;
            }
    }

    public static void maxHistogramArea(int height[]){
        Stack<Integer> s = new Stack<>();
        int ns_left[] = new int[height.length];
        int ns_right[] = new int[height.length];

        for(int i=0; i<height.length; i++){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
            ns_left[i] = -1;
            }
            else{
                ns_left[i] = s.peek();
            }
            s.push(i);
        }
        
        s = new Stack<>();

        for(int i=height.length-1; i>=0; i--){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
            ns_right[i] = height.length;
            }
            else{
                ns_right[i] = s.peek();
            }
            s.push(i);
        }
    int maxArea=0;
    for(int i=0; i<height.length; i++){
        int h = height[i];
        int w=ns_right[i]-ns_left[i]-1;
        int area=h*w;
            maxArea = Math.max(area, maxArea);
        }
        System.out.println("Max Area Histogram = "+maxArea);
    }
    public static void main(String[] args) {
    int height[] = {2, 1, 5, 6, 2, 3};
    maxHistogramArea(height);
    }
}

