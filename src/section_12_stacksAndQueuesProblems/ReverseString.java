package section_12_stacksAndQueuesProblems;

public class ReverseString {


    public static String reverseString(String str){
    	Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<(str.length());i++){
            stack.push(str.charAt(i));
        }
        
        String revStr="";
        for(int i=0;i<(str.length());i++){
            revStr=revStr+stack.pop();
        }
        
        return revStr;
        
    }
    


    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }



}
