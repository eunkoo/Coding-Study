package Euler2;

import java.util.Scanner;

public class EvenFibonacciNumbers {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            long n = in.nextLong();
	            if(n < 2 ) {
	             System.out.println(0);
	             return;
	             }
	             long sum =2, fib1=1, fib2=2, len = Long.parseLong(n+"");
	        
	             while((fib1 + fib2) < len){
	                if((fib1 + fib2)%2==0) sum += (fib1 + fib2);
	                
	                long tmp = fib2;
	                fib2 = (fib1 + fib2);
	                fib1 = tmp;
	                //System.out.println(sum);
	            }
	            System.out.println(sum);
	        }
	    }
}
