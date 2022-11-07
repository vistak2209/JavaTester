package org.example.leetcode.medium;

import org.example.leetcode.TestCase;

import java.awt.*;
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
        testCaseList.add(new TestCase("1baabad","baab"));
        testCaseList.add(new TestCase("baabad","baab"));
        testCaseList.add(new TestCase("babaj","bab"));
        testCaseList.add(new TestCase("cbbd","bb"));
        testCaseList.add(new TestCase("444ccaseess7sseesacc123","ccaseess7sseesacc"));
        Solution solution = new Solution();
        for(TestCase testCase:testCaseList){
            solution = new Solution();
            String output = solution.longestPalindrome(testCase.test);
            if(!testCase.checkAnswer(output)){
                System.out.println("answer: "+output+" for the test :"+testCase.test+" is wrong");
            }
        }
    }
}

class SimpleSolution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }}
class OfficialSolution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
class Solution {
    /* ###################Sliding Window###################
    * -----------Using String append Version-------------
    * Runtime: 1344 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 279.2 MB, less than 5.94% of Java online submissions for Longest Palindromic Substring.
    * -----------Using StringBuffer Version--------------
    * Runtime: 272 ms, faster than 27.51% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 68.5 MB, less than 25.10% of Java online submissions for Longest Palindromic Substring.
    * -----------Using StringBuffer Version override answer--------------
    * Runtime: 194 ms, faster than 33.67% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 42.7 MB, less than 69.77% of Java online submissions for Longest Palindromic Substring.
    * ----------Using index and return subString------------------------
    * Runtime: 28 ms, faster than 82.60% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 42.9 MB, less than 64.79% of Java online submissions for Longest Palindromic Substring.
    * ----------don't covert charArray----------------------------------
    * Runtime: 22 ms, faster than 91.63% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 41.9 MB, less than 95.88% of Java online submissions for Longest Palindromic Substring.
    * ----------divide into two method----------------------------------
    * Runtime: 28 ms, faster than 82.68% of Java online submissions for Longest Palindromic Substring.
    * Memory Usage: 42.9 MB, less than 64.62% of Java online submissions for Longest Palindromic Substring.
    * */
    int startIndex=0;
    int endIndex=0;
    int sSize=0;
    private void extendPalindrome(int anchor,int shift,String s){
        int left = anchor;
        int right= anchor+shift;
        if(left<0||right>=sSize)return;
        if(!(s.charAt(left)==s.charAt(right)))return;
        while((left-1>=0 && right+1<sSize) && s.charAt(left-1)==s.charAt(right+1)){
            left--;
            right++;
        }
        if((right-left)>(endIndex-startIndex)){
            startIndex=left;
            endIndex=right;
        }
    }
    public String longestPalindrome(String s) {
        sSize=s.length();
        for(int i=0;i<sSize;i++){
            extendPalindrome(i,1,s);
            extendPalindrome(i,0,s);
        }
        return s.substring(startIndex,endIndex+1);
    }
}