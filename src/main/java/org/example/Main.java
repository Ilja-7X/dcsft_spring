package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        int N = 65536;

        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Double> lambda = new ArrayList<>();
        ArrayList<Integer> mu = new ArrayList<>();


        File inFile = new File("in2.txt");
        Scanner scanner = new Scanner(inFile);

        String str;
        String[] memberString;
        for(int i = 0; i < 4; i++)
        {
            str = scanner.nextLine();
            memberString = str.split(" ");
            switch (i) {
                case 0:
                    for(String num : memberString) {
                        n.add(Integer.parseInt(num));
                    }

                    for(Integer num : n) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 1:
                    for(String num : memberString) {
                        m.add(Integer.parseInt(num));
                    }

                    for(Integer num : m) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    for(String num : memberString) {
                        lambda.add(Double.parseDouble(num));
                    }

                    for(Double num : lambda) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 3:

                    for(String num : memberString) {
                        mu.add(Integer.parseInt(num));
                    }

                    for(Integer num : mu) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
            }
        }

        File outFile = new File("out.txt");
        int i = 55;

        try (PrintWriter out = new PrintWriter(outFile, StandardCharsets.UTF_8))
        {
            out.print(i);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}