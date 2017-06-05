package Euler7;

import java.util.Scanner;

public class Prime10001st {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int cnt =0, tar = 2;
	            int[] prims = new int[n];
	            while(cnt < n){
	                int m = tar,  i = 0;
	                boolean find =true;
	                while(i < cnt ){
	                    //System.out.println(i+" a "+prims[i]);
	                    if(m%prims[i]==0){
	                        find = false;
	                        break;
	                    }
	                    if(prims[i]*prims[i]>m) break;
	                    i++;
	                }
	                if(find){
	                    prims[cnt]= tar;
	                    cnt++;  
	                    //System.out.println(i+" b "+prims[i]);
	                } 
	                tar ++;
	            }
	            System.out.println(tar-1);
	        }
	    }
}
