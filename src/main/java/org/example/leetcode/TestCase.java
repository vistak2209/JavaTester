package org.example.leetcode;

public class TestCase {
    public String test;
    public String answer;
    public TestCase( String test,String answer){
        this.test   = test;
        this.answer = answer;
    }
    public boolean checkAnswer(String answer){
        return answer.equals(this.answer);
    }
}
