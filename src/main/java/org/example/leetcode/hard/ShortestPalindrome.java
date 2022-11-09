package org.example.leetcode.hard;

import org.example.leetcode.TestCase;


import java.lang.reflect.Array;
import java.util.Arrays;
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

aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
*/
/*
* class Solution {
public:
    string shortestPalindrome(string s) {
        int n = s.size();
        string rev(s);
        reverse(rev.begin(), rev.end());
        string s_new = s + "#" + rev;
        int n_new = s_new.size();
        vector<int> f(n_new, 0);
        for (int i = 1; i < n_new; i++) {
            int t = f[i - 1];
            while (t > 0 && s_new[i] != s_new[t]) {
                t = f[t - 1];
            }
            if (s_new[i] == s_new[t]) {
                ++t;
            }
            f[i] = t;
        }
        return rev.substr(0, n - f[n_new - 1]) + s;
    }
};
* */
public class ShortestPalindrome {
    public static void main(String[] args)
    {
        List<TestCase> testCaseList = new LinkedList<>();
        testCaseList.add(new TestCase("aacecaaa","aaacecaaa"));
        testCaseList.add(new TestCase("abcd","dcbabcd"));
        testCaseList.add(new TestCase("abbacd","dcabbacd"));
        //testCaseList.add(new TestCase("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

        for(TestCase testCase:testCaseList){
            MySolution solution = new MySolution();
            String output = solution.shortestPalindrome(testCase.test);
            if(!testCase.checkAnswer(output)){
                System.out.println("answer: "+output+" for the test :"+testCase.test+" is wrong");
            }else {
               // System.out.println("answer: "+output+" for the test :"+testCase.test+" is right");
            }
        }
    }

}
/*
*==============Sliding Window===================
* ---------string buffer----------------------
* Time Limit Exceeded
* ---------add margin----------------------
* Time Limit Exceeded
* --------Use part string,part buffer---
* Time Limit Exceeded
* ---------use chars--------------------
* Runtime: 397 ms, faster than 13.13% of Java online submissions for Shortest Palindrome.
* Memory Usage: 42.7 MB, less than 83.17% of Java online submissions for Shortest Palindrome.
* */
class MySolution {
    int sSize=0;
    private boolean extendPalindrome(char[] characters,int margen){
        for(int i=sSize-margen;i>0;i--){
            if(characters[i]!=characters[sSize-i-margen])return false;
        }
        return true;
    }
    private void reverse(char[] characters){
        int cSize = characters.length;
        for(int i=0;i<cSize/2;i++){
            char c = characters[i];
            characters[i]=characters[cSize-i-1];
            characters[cSize-i-1] = c;
        }
    }
     public String shortestPalindrome(String s) {
        int index=0;
         sSize = s.length()-1;
        //StringBuffer buffer = new StringBuffer();
        char[] characters =s.toCharArray();
        reverse(characters);
        while(!extendPalindrome(characters,index)){
            //buffer.append(characters[sSize-index]);
            index++;
        }
        char answer[]= new char[index];
         answer=Arrays.copyOfRange(characters,0,index);
        return String.valueOf(answer)+s;
    }
}
