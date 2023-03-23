package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Lab3Graphics {
    public static void main(String[] args) {
        int N = 65536;

        int m_ = 1;
        int mu = 10;
        double theta;
        double tau;
        double lambda = 1E-7;

        List<Double> arrLambda = new ArrayList<>();
        arrLambda.add(1E-7);
        arrLambda.add(1E-6);
        arrLambda.add(1E-5);

        int i = 1;

            //for(double lambda : arrLambda){
                //for(int mu = 1; mu <= 1000; mu*=10){

                    for(int m = m_; m <= 3; m++){
                    File outFile = new File("Lab3/out_data/out6_" + i++ + ".txt");
                    try (PrintWriter out = new PrintWriter(outFile, StandardCharsets.UTF_8)){
                        for(int n = 65527; n <= 65536; n++){
                            theta = Theta.calculate(N, n, m, lambda, mu);
                            out.print(n + " " + theta + '\n');
                            //tau = Tau.calculate(N, n, m, lambda, mu);
                            //out.print(n + " " + tau + '\n');
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }

                //}
            //}
            System.out.println("done!");
    }
}
