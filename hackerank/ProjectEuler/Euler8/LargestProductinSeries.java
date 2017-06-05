package Euler8;

import java.util.Scanner;

public class LargestProductinSeries {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int k = in.nextInt();
	            String num = in.next();
	            
	            int l =0;
	            int  max=0;
	            while(l+k <= n){
	                int lNum = Integer.parseInt(num.substring(l,l+k)), mMul=1;
	                while(lNum > 0){
	                    mMul *= lNum%10;
	                    lNum/=10;
	                    //System.out.println("mMul "+mMul);
	                }
	                max = Math.max(max, mMul);
	                l++;
	                
	            }
	            System.out.println(max);
	        }
	    }
}
