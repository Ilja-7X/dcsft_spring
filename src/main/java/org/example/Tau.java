package org.example;

public class Tau {
    public static double calculate(int N, int n, int m, double lambda, int mu)
    {
        double product1 = 1.0 / (mu * m) ;
        for(int l = 1; l < n; l++) {
            product1 *= (l * lambda) / (mu * l);
        }

        double sum = 0.0;
        for(int j = 1; j <= n - 1; j++) {
            double product2 = 1.0;
            for(int l = j; l <= n - 1; l++){
                int mu_l = 1;
                if(l >= N-m &&  l <= N) {
                    mu_l = (N - l) * mu;
                }
                else if(l >= 0 &&  l < N-m) {
                    mu_l = m * mu;
                }
                product2 *= (l * lambda) / mu_l;
            }
            sum += product2 / (j * lambda);
        }
        double result = product1 + sum;

        return result;
    }
}
