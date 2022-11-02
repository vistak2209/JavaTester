package org.example.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given a string s, return the longest palindromic substring in s.
A string is called a palindrome string if the reverse of that string is the same as the original string.
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
*/
public class LongestPalindromic {
    public static void main(String[] args)
    {
        List<TestCase> testCaseList = new LinkedList<>();
        testCaseList.add(new TestCase("weqwbaabad","baab"));
        testCaseList.add(new TestCase("baabad","baab"));
        testCaseList.add(new TestCase("babad","bab"));
        testCaseList.add(new TestCase("cbbd","bb"));
        testCaseList.add(new TestCase("444ccaseess7sseesacc123","ccaseess7sseesacc"));
        Solution solution = new Solution();
        for(TestCase testCase:testCaseList){
            String output = solution.longestPalindrome(testCase.test);
            if(!testCase.checkAnswer(output)){
                System.out.println("answer: "+output+" for the test :"+testCase.test+" is wrong");
            }
        }
    }
}
class TestCase {
    String test;
    String answer;
    TestCase( String test,String answer){
        this.test   = test;
        this.answer = answer;
    }
    boolean checkAnswer(String answer){
        return answer.equals(this.answer);
    }


}
class Solution {
    /*
    * -----------Using String append Version-------------
    * Runtime: 1344 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 279.2 MB, less than 5.94% of Java online submissions for Longest Palindromic Substring.
    * -----------Using StringBuffer Version--------------
    * Runtime: 272 ms, faster than 27.51% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 68.5 MB, less than 25.10% of Java online submissions for Longest Palindromic Substring.
    * */
    public String longestPalindrome(String s) {
        List<String> condidates = new LinkedList<>();
        String answer = "";
        Stack<Character>charStack=new Stack<>();
        char[] cList = s.toCharArray();
        if(cList.length==1)return s;
        if(cList.length==2 && cList[0]==cList[1] )return s;
        else if(cList.length==2) return ""+cList[0];
        for(int i=0;i<cList.length;i++){
            //--------odd------------------
            StringBuffer buffer = new StringBuffer();
            buffer.append(cList[i]+"");
            int j =1;
            while(i-j>=0 && i+j!= cList.length){
                if(cList[i-j]==cList[i+j]){
                    buffer.append(cList[i+j]);
                    buffer.insert(0,cList[i-j]);
                    j++;
                } else {
                    break;
                }
            }
            if(buffer.length()>1){condidates.add(buffer.toString());}


            buffer = new StringBuffer();
            j =1;
            int k =0;
            while(i-k>=0 && i+j!= cList.length){
                if(cList[i-k]==cList[i+j]){

                    buffer.append(cList[i+j]);
                    buffer.insert(0,cList[i-k]);
                    j++;
                    k++;
                } else {
                    break;
                }
            }
            if(buffer.length()>1){condidates.add(buffer.toString());}


        }
        if(condidates.size()==0)return ""+cList[0];
        for(String condidate:condidates){
            if(condidate.length()>answer.length()){answer=condidate;}
        }

        return answer;



    }
}