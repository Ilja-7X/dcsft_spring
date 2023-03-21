package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Lab2 {
    private static long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    private static int delta(double x) {
        return x > 0 ? 1 : 0;
    }

    private static List<Double> countP(int N, double nu, double lambda) {
        List<Double> P = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            double sum = 0;
            for (int l = 0; l <= N; l++) {
                sum += Math.pow(nu / lambda, l) / factorialUsingStreams(l);
            }
            P.add(Math.pow(nu / lambda, i) / factorialUsingStreams(i) * Math.pow(sum, -1));
        }
        return P;
    }

    private static List<Double> countQ(int n, int N, double m, double nu, double lambda, int t) {
        List<Double> Q = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            double u = 0;
            for (int l = 0; l <= n; l++) {
                double pi = countPi(n, lambda, t, i, l);

                u += Math.pow(nu * t, l) / factorialUsingStreams(l) * (delta(N - i - m) * Math.pow(m, l) *
                        Math.pow(Math.E, -m * nu * t) +
                        delta(m - N + i) * Math.pow(N - i, l) * Math.pow(Math.E, -(N - i) * nu * t)) * pi;
            }
            Q.add(u);
        }
        return Q;
    }

    private static Double countPi(int n, double lambda, int t, int i, int l) {
        double pi = 0;
        for (int r = 0; r <= i - n + l; r++) {
            pi += Math.pow(i * lambda * t, r) / factorialUsingStreams(r) * Math.pow(Math.E, -i * lambda * t);
        }
        return pi;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double m = Double.parseDouble(args[2]);
        double nu = Double.parseDouble(args[3]);
        double lambda = Double.parseDouble(args[4]);
        List<Double> R_star = new ArrayList<>();
        List<Double> U_star = new ArrayList<>();

        System.out.println("N = "+ N +", n = " + n + ", m = " + m + ", nu = " + nu + " lambda = " + lambda);


//        Path path = Path.of(new java.io.File(".").getCanonicalPath() + "/out_data/R" + n + ".txt");
//        FileWriter fw = new FileWriter(String.valueOf(path));
        for (int t = 0, index = 0; t <= 24; t += 2, index++) {

            List<Double> P = countP(N, nu, lambda);
            List<Double> Q = countQ(n, N, m, nu, lambda, t);

            R_star.add(0D);
            for (int i = n; i <= N; i++) {
                R_star.set(index, R_star.get(index) + Q.get(i) * P.get(i));
            }
            //fw.write(t + " " + R_star.get(index) + '\n');
            //System.out.println(R_star.get(index));
        }

        for (int t = 0, index = 0; t <= 24; t +=2, index++) {
            List<Double> P = countP(N, nu, lambda);
//            List<Double> Q = countQu(n, N, m, nu, lambda, t);

            double mul = 0;
            for (int i = 0; i <= n-1; i++) {
                double pi = 0;
                for (int r = 0; r <= N; r++) {
                    double u = 0;
                    for (int l = 0; l <= n-i-1+r; l++) {
                        u += Math.pow(nu * t, l) / factorialUsingStreams(l) * (delta(N - i - m) * Math.pow(m, l) *
                                Math.pow(Math.E, -m * nu * t) +
                                delta(m - N + i) * Math.pow(N - i, l) * Math.pow(Math.E, -(N - i) * nu * t));
                    }
                    pi += Math.pow(i * lambda * t, r) / factorialUsingStreams(r) * Math.pow(Math.E, -i * lambda * t) * u;
                }
                mul += pi * P.get(i);
            }
            U_star.add(1 - mul);
            //System.out.println(U_star.get(index));
        }

        R_star = new ArrayList<>();
        for (int n_ = 11, index = 0; n_ <= 16; n_++, index++) {

            List<Double> P = countP(N, nu, lambda);
            List<Double> Q = countQ(n_, N, m, nu, lambda, 0);

            R_star.add(0D);
            for (int i = n_; i <= N; i++) {
                double mul = Q.get(i) * P.get(i);
                R_star.set(index, R_star.get(index) + mul);
            }
            //fw.write(t + " " + R_star.get(index) + '\n');
            //System.out.println(R_star.get(index));
        }

        /*for (int n_ = 11; n_ <= 16; n_++) {
            double s_ = 0;
            for (int j = 0; j <= n_; j++ ) {
               s_ += Math.pow(29.583, j) * Math.pow(2.7182818285, -29.583) / (factorialUsingStreams(j));
            }
            double result = 1 - s_;
            System.out.println("n=" + n_ + ": " + result);
       }*/
        /*System.out.println("");
        for (int n_ = 11; n_ <= 16; n_++) {
            double s_ = 1 - Math.pow(lambda, N - n_ + 1) * Math.pow(lambda + nu, -(N-n_+1));

            System.out.println("n=" + n_ + ": " + s_);
        }*/
    }
}
