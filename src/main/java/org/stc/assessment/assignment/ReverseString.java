package org.stc.assessment.assignment;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {

    public String reverse(String s) {
        Deque<StringBuilder> deque = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                deque.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                current.reverse();
                current = deque.pop().append("(").append(current).append(")");
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }

  /*  public static void main(String[] args) {
        System.out.println(reverseParentheses("abd(jnb)asdf")); // Output: abd(bnj)asdf
        System.out.println(reverseParentheses("abdjnbasdf"));   // Output: abdjnbasdf
        System.out.println(reverseParentheses("dd(df)a(ghhh)")); // Output: dd(fd)a(hhhg)
    }*/
}
