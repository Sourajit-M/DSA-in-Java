public class reverseWords {
    public static String reverseWords(String s) {
        s.trim();
        String str[] = s.split(" ");

        String st = "";
        for(int i=str.length-1; i>=0; i--){
            st += str[i] + " ";
        }

        return st.trim(); 
    }

    public static String reverseWords_2(String s){
        String ans="";
        String temp="";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch!=' '){
                temp += ch;
            }else if(ch == ' '){
                if(temp.equals("")){
                    continue;
                }
                if(ans != ""){
                    ans = temp + " " + ans;
                }else{
                    ans = temp;
                }
                temp = "";
            }
        }

        if(temp!=""){
            if(ans!=""){
                ans = temp + " " + ans;
            }else{
                ans = temp;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords_2(s));
        // System.out.println("sourajit".substring(0, 7));
    }
}
