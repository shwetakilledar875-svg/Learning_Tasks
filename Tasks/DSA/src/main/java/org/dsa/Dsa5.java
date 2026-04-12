package org.dsa;

public class Dsa5 {
    public int lengthOfLastWord(String s) {
        int count=0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        while(i>=0 && s.charAt(i) != ' '){
            count++;
            i--;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "Hello World";
        Dsa5 dsa5 = new Dsa5();
        int result = dsa5.lengthOfLastWord(s);
        System.out.println("Length of last word: " + result);
    }
}
