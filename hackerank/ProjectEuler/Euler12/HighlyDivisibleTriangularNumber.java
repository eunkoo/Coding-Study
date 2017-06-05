package Euler12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HighlyDivisibleTriangularNumber {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        HashMap<Integer,Integer> map = new HashMap<>();
	        List<Integer> cLst = new ArrayList<>();
	        map.put(0,1);
	        map.put(1,3);
	        cLst.add(0);
	        cLst.add(1);
	        Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        
	        for(int j=0;j<T;j++){
	            int n = in.nextInt(), max = 0;
	            boolean find=false;
	            //System.out.println(" n "+n);
	            for(int i=0;i<cLst.size();i++)
	                if(cLst.get(i)>=n){
	                    System.out.println(map.get(cLst.get(i)));
	                    find=true;
	                    break;
	                }
	            if(find) continue;
	            
	            
	        int tar = 0, offset=0;
	            while(tar < Integer.MAX_VALUE){
	                int pCnt= n == 1 ? 0 : 1;
	                int i=2;
	                offset++;
	                tar += offset;
	                while(i*i <=tar){
	                    if(tar%i==0) pCnt+=2;
	                    if(i*i==tar) pCnt-=1;
	                    i++;
	                }
	                if(!map.containsKey(pCnt)){
	                    map.put(pCnt,tar);
	                    cLst.add(pCnt);
	                    //System.out.println("pCnt"+pCnt+" "+tar);
	                }
	                    
	                    //System.out.println("pCnt"+pCnt+" "+tar);
	               //     max = pCnt;
	               // }
	                if(pCnt >= n){
	                    //map.put(n,tar);
	                    System.out.println(tar);
	                    break;
	                }
	            }
	            
	        }
	    }
}
