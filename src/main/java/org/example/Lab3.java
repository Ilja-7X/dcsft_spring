package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {
    public static void main(String args[]) {
        //try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

            /*StringBuilder sb = new StringBuilder();
            sb.append("id");
            sb.append(',');
            sb.append("Name");
            sb.append(',');
            sb.append("Address");
            sb.append('\n');

            sb.append("101");
            sb.append(',');
            sb.append("John Doe");
            sb.append(',');
            sb.append("Las Vegas");
            sb.append('\n');

            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");*/

        /*} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        int N_ = 65536;
        int n_ = 65527;
        int m_ = 1;
        double lambda_ = 1E-7;
        int mu_ = 1;
        int sumCount = 1;
        double theta;
        double tau;

        long timeElapsed = 0;

        try (PrintWriter writer = new PrintWriter(new File("Lab3/out_data/table.csv"))) {
            StringBuilder sb0 = new StringBuilder("№,lambda,mu,m,n,Theta,Tau\n");
            writer.write(sb0.toString());


            //for(double lambda = lambda_; lambda <= 1E-5; lambda *= 10){
                //for(int mu = mu_; mu <= 1000; mu*=10){
                    //for(int m = m_; m <= 3; m++){
                        //for(int n = n_; n <= 65536; n++){
                            //System.out.println(n_cur + " = " +Tau.calculate(N, n_cur, m_cur, lambda_cur, mu_cur));
                            //out.print(n_cur + " " + Tau.calculate(N, n_cur, m_cur, lambda_cur, mu_cur) + "\n");
            long start = System.currentTimeMillis();

            for(int i = 0; i < 10; i++) {

                long start1 = System.currentTimeMillis();
                theta = Theta.calculate(N_, n_, m_, lambda_, mu_);
                tau = Tau.calculate(N_, n_, m_, lambda_, mu_);
                long finish1 = System.currentTimeMillis();
                timeElapsed += finish1 - start1;
                System.out.println(timeElapsed);


                StringBuilder sb = new StringBuilder();


                sb.append(sumCount);
                sb.append(',');
                sb.append(lambda_);
                sb.append(',');
                sb.append(mu_);
                sb.append(',');
                sb.append(m_);
                sb.append(',');
                sb.append(n_);
                sb.append(',');
                sb.append(theta);
                sb.append(',');
                sb.append(tau);
                sb.append("\n");
                writer.write(sb.toString());
                writer.flush();

                sumCount++;
            }
            double finish = System.currentTimeMillis();
            double timeElapsedAll = finish - start;
            System.out.println("AvgTime = " + timeElapsed/10);
            System.out.println("OverheadTime = " + (timeElapsedAll - timeElapsed));
                        //}
                    //}
                //}
            //}

            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
