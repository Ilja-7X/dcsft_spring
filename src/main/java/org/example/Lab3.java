package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        int N_ = 65536;
        int n_ = 65527;
        int m_ = 1;
        int mu_ = 1;
        int sumCount = 1;
        double theta;
        double tau;

        List<Double> arrLambda = new ArrayList<>();
        arrLambda.add(1E-7);
        arrLambda.add(1E-6);
        arrLambda.add(1E-5);

        try (PrintWriter writer = new PrintWriter(new File("Lab3/out_data/table.csv"))) {
            StringBuilder sb0 = new StringBuilder("№,lambda,mu,m,n,Theta,Tau\n");
            writer.write(sb0.toString());

            for (double lambda : arrLambda) {
                for (int mu = mu_; mu <= 1000; mu *= 10) {
                    for (int m = m_; m <= 3; m++) {
                        for (int n = n_; n <= 65536; n++) {
                            theta = Theta.calculate(N_, n, m, lambda, mu);
                            tau = Tau.calculate(N_, n, m, lambda, mu);

                            StringBuilder sb = new StringBuilder();

                            sb.append(sumCount);
                            sb.append(',');
                            sb.append(lambda);
                            sb.append(',');
                            sb.append(mu);
                            sb.append(',');
                            sb.append(m);
                            sb.append(',');
                            sb.append(n);
                            sb.append(',');
                            sb.append(theta);
                            sb.append(',');
                            sb.append(tau);
                            sb.append("\n");
                            writer.write(sb.toString());
                            writer.flush();
                            sumCount++;
                        }
                    }
                }
            }
            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
