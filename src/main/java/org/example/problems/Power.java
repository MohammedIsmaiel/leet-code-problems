package org.example.problems;

public class Power {
    public double myPow(double x, int n) {
        double result = x;
        if (result == 1 || result == 0) {
            return result;
        }
        for (int i = 1; i < Math.abs(n); i++) {
            result = result * x;
        }
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE)
            return 0;
        if (n < 0)
            return 1 / result;
        else
            return result;
    }

    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }

    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = myPow(x, (n - 1) / 2);
            return temp * temp * x;
        }
    }

}
