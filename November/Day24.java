//SC: O(n)
//TC: O(n)
class Solution {
    public int calculate(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        
        Stack<Integer> stack = new Stack();
        char sign = '+';
        int result = 0, num = 0;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            //keep on adding digits to form a number
            if(Character.isDigit(ch))
                num = num * 10 + ch - '0';
            
            //in case we encounter an operation symbol or the current char is last in string
            if((!Character.isDigit(ch) && ch != ' ') || i == n - 1){
                switch(sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;    
                    case '*':
                        stack.push(stack.pop() * num);//get top of stack and multiply it with current num, then push since * has higher precedence than + or -
                        break;
                    case '/':
                        stack.push(stack.pop() / num);//get top of stack and divide it with current num, then push since / has higher precedence than + or -
                        break;
                }
                sign = ch;
                num = 0;
            }
        }
        //add all the contents of stack at the end
        for(int res: stack)
            result += res;
        
        return result;
    }
}