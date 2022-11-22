package org.example.tools.vocabulary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final int PICK_COUNT = 5;
    private static final int PICK_PERIOD= 600000;//6000ms X1000 =10m
    private static HashSet<String> getLines(File file) throws FileNotFoundException {
        HashSet<String> lines = new HashSet<>();
        Scanner reader = new Scanner(new FileInputStream(file));
        while (reader.hasNextLine()){
            String line =  reader.nextLine();
            String[]spilt = line.split(",");
            if(spilt.length!=2)continue;
            String formalLine = String.format("[%s] ",spilt[0])+line.substring(spilt[0].length()+1,line.length());
            lines.add(formalLine);
            //System.out.println(String.format("[%s] %s", spilt[0],spilt[1]));

        }
        return lines;
    }
    private static ArrayList<String>randomPick(File[] files) throws FileNotFoundException {
        HashSet<String> lines = new HashSet<>();
        for(File file:files){
            if(file.isDirectory())continue;
            lines.addAll(getLines(file));
        }
        ArrayList<String> printLine = new ArrayList<>();
        printLine.addAll(lines);
        return printLine;
    }
    private static void print(ArrayList<String> lines){
        HashSet<String> printLine = new HashSet<>();
        Random random = new Random(System.currentTimeMillis());
        while (printLine.size()<PICK_COUNT){
            printLine.add(lines.get(random.nextInt(lines.size())));
        }
        for(String line:printLine){
            System.out.println(line);
        }
    }
    public static void main(String[] args){
        String scanDirPath = args[0];
        //String scanDirPath = "/tmp/test/";
        File scanDir = new File(scanDirPath);
        File[] files = scanDir.listFiles();
        try {
            while (true){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(String.format("==============[%s]===============", new Date(System.currentTimeMillis())));
                ArrayList<String> printLine = randomPick(files);
                print(printLine);
                Thread.sleep(PICK_PERIOD);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}