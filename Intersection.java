package com.progKiev;


import java.io.*;
import java.util.*;


public class Intersection {

    public static String read(File file) throws IOException {
        String result = "";
        try{
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                result += line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String intersection(File first, File second) throws IOException {
        String f = read(first);
        String s = read(second);

        String fArr[] = f.split("\\s+");
        String sArr[] = s.split("\\s+");

        HashSet<String> mySet = new HashSet<String>();
        for(String j: fArr) {
            for (String i : sArr) {
                if(i.equals(j)){
                    mySet.add(i);
                }
            }
        }

        String ans = "";
        for(String i: mySet){
            ans += i + " ";
        }
        return ans.trim();
    }

    public static void write(String data) {
        File res = new File("res.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(res);
            fr.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
}
