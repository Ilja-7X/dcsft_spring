package org.example;

public class Theta {
    public static double calculate(int N, int n, int m, double lambda, int mu)
    {
        double res1 = 0;
        for (int j = n+1; j <= N; j++) {
            double res2 = 1;

            for(int l = n; l <= j-1; l++) {
                int mu_l;

                if(l >= N-m &&  l <= N) {
                    mu_l = (N - l) * mu;
                }
                else if(l >= 0 &&  l < N-m) {
                    mu_l = m * mu;
                }
                else
                {
                    mu_l = -1;
                    System.out.println("Error");
                }


                res2 *= (double) mu_l / l / lambda + (double) 1 / n / lambda;

            }
            res1 += (double) 1 / j / lambda * res2;
        }
        return res1;
    }
}
