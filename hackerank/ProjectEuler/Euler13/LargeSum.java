package Euler13;

import java.util.Scanner;

public class LargeSum {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner s = new Scanner (System.in);
        int N = Integer.parseInt(s.nextLine());
        int count = N;
        long ul=0;
        while(count>0){
            String str = s.nextLine();
            ul += Long.parseLong(str.substring(0,15)); 
            count--;
        }
        String res = ul+"";
        System.out.println(res.substring(0,10));
    }
}
