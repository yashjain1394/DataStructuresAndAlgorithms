package section_12_stacksAndQueuesProblems;

public class ParenthesesBalanced {

    
    public static boolean isBalancedParentheses(String str){
    	Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            if(str.charAt(i)==')'){
                if(stack.size()!=0){
                    stack.pop();
                }
                else{
                    return false;
                }
                
            }
        }
        
        if(stack.size()==0){
            return true;
        }
        else{
            return false;
        }
    }




    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }
    
    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);
        
        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);
        
        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }
        
        // Print a separator for better readability
        System.out.println("--------------");
    }



}
