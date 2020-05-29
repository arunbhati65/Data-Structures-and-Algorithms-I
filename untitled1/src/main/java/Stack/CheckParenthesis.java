package main.java.Stack;

import java.util.HashMap;
import java.util.Stack;

public class CheckParenthesis {
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; ++i) {
            Character top = stack.isEmpty() ? null : stack.peek();
            if (top != null && isOpenBracket(top) && !isOpenBracket(arr[i])) {
                if (map.get(top).equals(arr[i])) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(arr[i]);
            }
        }
        return true;
    }

    static boolean isOpenBracket(char c) {
        if (c == '(' || c == '{' || c == '[')
            return true;
        return false;
    }

    public static void main(String args[]) {
        System.out.println(isValid("(){}[]"));
    }
}
