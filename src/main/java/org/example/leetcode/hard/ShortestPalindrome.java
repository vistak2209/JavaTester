package org.example.leetcode.hard;

import org.example.leetcode.TestCase;


import java.util.LinkedList;
import java.util.List;

/*
You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.
Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"
*/
public class ShortestPalindrome {
    public static void main(String[] args)
    {
        List<TestCase> testCaseList = new LinkedList<>();
        testCaseList.add(new TestCase("aacecaaa","aaacecaaa"));
        testCaseList.add(new TestCase("abcd","dcbabcd"));
        testCaseList.add(new TestCase("abbacd","dcabbacd"));

        for(TestCase testCase:testCaseList){
            MySolution solution = new MySolution();
            String output = solution.shortestPalindrome(testCase.test);
            if(!testCase.checkAnswer(output)){
                System.out.println("answer: "+output+" for the test :"+testCase.test+" is wrong");
            }else {
                System.out.println("answer: "+output+" for the test :"+testCase.test+" is right");
            }
        }
    }

}
/*
*==============Sliding Window===================
* ---------string buffer----------------------
* Time Limit Exceeded
*
* */
class MySolution {
    private boolean extendPalindrome(StringBuffer buffer ){
        int len =buffer.length()-1;
        for(int i=0;i<len;i++){
            if(buffer.charAt(i)!=buffer.charAt(len-i))return false;
        }
        return true;
    }
     public String shortestPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for(char c:s.toCharArray()){
            buffer.append(c);
        }
        int index=1;
        while(!extendPalindrome(buffer)){
            buffer.insert(index-1,buffer.charAt(buffer.length()-index));
            index++;
        }

        return buffer.toString();
    }
}
