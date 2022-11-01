package org.example;
import java.util.regex.*;
public class RegexTest {
    private final static String VERSION_REGEX="(?:(\\d+)\\.)?(?:(\\d+)\\.)?(?:(\\d+)\\.\\d+)";
    //private final static String VERSION_REGEX="(\\d+)\\.(\\d+)(\\.(\\d+))?";
    public static void main(String[] args)
    {
        String tagName = "private-cloud-1.1.1";
        parserVersion(tagName);
        //System.out.println();

    }
    private static void parserVersion(String tagName){
        Pattern pattern = Pattern.compile(VERSION_REGEX);
        Matcher matcher = pattern.matcher(tagName);
        matcher.find();
       // System.out.println(matcher.groupCount()+"  "+matcher.matches());

        String version =  matcher.group(0);
        System.out.println(version);
        //return version;
    }
}
