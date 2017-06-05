package Euler9;

import java.util.Scanner;

public class SpecialPythagoreanTriplet {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long a = n/3;
            boolean find = false;
            while(a > 0){
                long c = ((((n-a)*(n-a))+(a*a))/(2*(n-a)));
                long b = n-a-c;
                //System.out.println(a+" "+b+" "+c);
                if( b>0 && c >0 && a+b+c==n && a*a+b*b-c*c==0 && a<b && b<c){
                    System.out.println(a*b*c);
                    find = true;
                    break;
                }
                a--;
            }
            if(!find)   System.out.println(-1);
        }
    }
}
