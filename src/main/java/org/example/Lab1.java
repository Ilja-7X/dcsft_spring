package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Lab1 {
    public static void main(String[] args) throws IOException {
        int N = 8192;

        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Double> lambda = new ArrayList<>();
        ArrayList<Integer> mu = new ArrayList<>();


        File inFile = new File("in_data/in5.txt");
        Scanner scanner = new Scanner(inFile);

        String str;
        String[] memberString;

        for(int i = 0; i < 4; i++)
        {
            str = scanner.nextLine();
            memberString = str.split(" ");
            /*
            1. n
            2. m
            3. lambda
            4. mu
            */
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

        int i = 1;


        for(Double lambda_cur : lambda){
            for(Integer mu_cur : mu){
                for(Integer m_cur : m){
                    File outFile = new File("out_data/out5_" + i++ + ".txt");
                    try (PrintWriter out = new PrintWriter(outFile, StandardCharsets.UTF_8)){
                    // System.out.println("mu = " + mu_cur);
                    for(Integer n_cur : n){
                        System.out.println(n_cur + " = " +Tau.calculate(N, n_cur, m_cur, lambda_cur, mu_cur));
                        out.print(n_cur + " " + Tau.calculate(N, n_cur, m_cur, lambda_cur, mu_cur) + "\n");
                    }
                        System.out.println("-----------------------------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /*int m_cur = 1;
        //int N_cur = 65536;
        int mu_cur = 1;
        double lambda_cur = 0.00001;//1E-5;
        for(Integer n_cur : n){
            System.out.println(n_cur + " = " +calculate(N, n_cur, m_cur, lambda_cur, mu_cur));
        }
        System.out.println("-----------------------------");*/



        /*int i = 55;

        try (PrintWriter out = new PrintWriter(outFile, StandardCharsets.UTF_8))
        {
            out.print(i);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}