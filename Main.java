package com.progKiev;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void testCopy(){
        File sourceFolder = new File("C:\\Users\\Никита\\Desktop\\PROJ_KIEV\\");
        File receiverFolder = new File("myFolder");
        if (!receiverFolder.exists()) {
            if (receiverFolder.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        MyFileFilter mFF = new MyFileFilter("doc");

        File[] fileList = sourceFolder.listFiles(mFF);


        for (File file : fileList) {
            try {
                FileService.copyFile(file, new File(receiverFolder + "\\" + file.getName()), 10000000);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void testIntersection(){
        File f1 = new File("123.txt");
        File f2 = new File("321.txt");
        try {
            System.out.println(Intersection.read(f1));
            System.out.println(Intersection.read(f2));
            String result = Intersection.intersection(f1, f2);
            Intersection.write(result);

            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testCopy();

        testIntersection();



    }
}
