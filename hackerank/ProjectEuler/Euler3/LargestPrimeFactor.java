package Euler3;

import java.util.Scanner;

public class LargestPrimeFactor {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(getFactor(n));
        }
    }
    static long getFactor(long n){
        long i = 2, large_prime=2;
        while(i*i <= n){
            while(n%i==0){
                large_prime = i;
                n/=i;
            }
            i++;
        }
        return large_prime < n ? n : large_prime;
    }
}
