package Euler1;

import java.util.Scanner;

public class Multiple3and5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            long thr = (n-1)/3;
            long fiv = (n-1)/5;
            long fit = (n-1)/15;
            
            long res= 3*thr*(thr+1)/2 + 5*fiv*(fiv+1)/2 - 15*fit*(fit+1)/2;
            System.out.println(res);
        }
    }
}
