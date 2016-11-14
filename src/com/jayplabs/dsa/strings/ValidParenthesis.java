package com.jayplabs.dsa.strings;

import java.util.Stack;

/**
 * Created by Chandra Gopalaiah on 9/26/16.
 */

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class ValidParenthesis {
    public static boolean checkParanthesis(String str) {
        if (str == null || str.length() == 0 ) return false;

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
            if (c == '(' || c == '{' || c == '[') stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkParanthesis("()[]{}"));
    }
}
