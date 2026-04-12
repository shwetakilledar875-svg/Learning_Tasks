package org.dsa;

//First Unique Character in a String
public class Dsa2 {
    public static void main(String[] args) {
        Dsa2 dsa2 = new Dsa2();
        String s = "leetcode";
        int result = dsa2.firstUniqChar(s);
        System.out.println(result);
    }
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int count=0;

            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==ch) {
                    count++;
                }
            }
            if(count==1){
                return i;
            }
        }
        return -1;
    }
}

