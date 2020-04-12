package ru.geekbrains.java3_lesson3_client_server;

import java.io.*;
import java.util.*;

public class Main_Lesson3 {

    public static void main(String[] args) throws IOException {
//        readFileAndShow();
//        sewFilesIntoOne(5);
        textfilesReader("C:\\Users\\Ghenadie\\IdeaProjects\\java3_lesson3\\src\\ru\\geekbrains\\java3_lesson3\\file_text.txt");
    }
    // Task 1
    public static void readFileAndShow () throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream
                ("C:\\Users\\Ghenadie\\IdeaProjects\\java3_lesson3\\src\\ru\\geekbrains\\java3_lesson3\\file1.txt"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int c;
        while ((c = bis.read()) != -1){
            baos.write(c);
        }
        byte [] arr = baos.toByteArray();
        System.out.println(Arrays.toString(arr));
        bis.close();
        baos.close();
    }
    // Task 2
    public static void sewFilesIntoOne(int quantity) throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            al.add(new FileInputStream
                    ("C:\\Users\\Ghenadie\\IdeaProjects\\java3_lesson3\\src\\ru\\geekbrains\\java3_lesson3\\fileN"+i+".txt"));
        }
        BufferedInputStream bis = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int c;
        while ((c = bis.read()) != -1){
            System.out.print((char) c);
        }
        bis.close();
    }
    // Task 3
    public static void textfilesReader(String file){
        final int SIZE_OF_PAGE = 1800;
        try {
            RandomAccessFile raf = new RandomAccessFile
                    (file, "r");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose and enter page: ");
            int pageNumber = scanner.nextInt() - 1;
            raf.seek(pageNumber * SIZE_OF_PAGE);
            for (int i = 0; i < SIZE_OF_PAGE; i++) {
                System.out.print((char) raf.read());

            }
            raf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
