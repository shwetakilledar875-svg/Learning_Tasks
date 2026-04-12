package org.dsa;


import java.util.Stack;

//Valid Parentheses
public class Dsa4 {
        public boolean isValid (String s){
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                else {
                    if (stack.isEmpty())
                        return false;
                    char top = stack.pop();

                    if (ch == ')' && top != '(')
                        return false;
                    if (ch == '}' && top != '{')
                        return false;
                    if (ch == ']' && top != '[')
                        return false;
                }

            }
            return stack.isEmpty();
        }
    public static void main(String[] args) {
        Dsa4 dsa4 = new Dsa4();
        String s = "{[()]}";
        boolean result = dsa4.isValid(s);
        if (result) {
            System.out.println("Valid parentheses");
        } else {
            System.out.println("Invalid parentheses");
        }
    }
}
