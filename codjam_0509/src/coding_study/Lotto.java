package coding_study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Lotto {
	int[] res = null;
	void printLotto(int[] s){
		if(s == null || s.length==0) return;
		int len = s.length;
		int offset = len - 6;
		res = new int[len];
		combination(s,res,0,len,6,0);
	}
	public static void combination(int[] arr,int[]res, int index, int n, int r,int tar) 
	{ 
		if (r == 0) print(res, index); 
		else if (tar == n) return; 
		else { 
			res[index] = arr[tar] ; 
			combination(arr,res, index + 1, n, r - 1,tar+1); 
			combination(arr,res, index, n, r,tar+1); 
		} 
	}//end combination() 
	public static void print(int[] arr, int length) { 
		for (int i = 0; i < length; i++) 
			System.out.print(arr[i]); 
		System.out.println(""); 
	}

	

	 void readfile(String path){
	        Scanner s = null;

	        try {
	            s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));//new FileReader(path)));//

	        	//int nTest = Integer.parseInt(s.nextLine());
	        	//System.out.println("number of test case : "+nTest);
	        	//for(int testcase=0;testcase<nTest;testcase++){
	            while(s.hasNextLine()){
	            	// int array:  length 1,2,3
	        		String line = s.nextLine();
	        		if(line.length()==0)break;
	        		//System.out.println("line "+line);
	        		String[] arr = line.split(" ");
	        		int k = Integer.parseInt(arr[0]);
	        		int[] cand = new int[k];
	        		for(int i=0;i<k;i++)
	        			cand[i] = Integer.parseInt(arr[i+1]);
	        		//System.out.println("ans"+answer);
	        		printLotto( cand);
	        		System.out.println();
	            	long start = System.nanoTime();
	            	//int res = canCompleteCircuit(gas, cost);
//	            	if(answer != res){
//	            		System.out.println("Fail !!! "+testcase+" res :"+res);
//	            		
//	            	}
//	            	if(s.hasNextInt())
//	            		break;
	        	}
	           // }
//	        } catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			} 
	        finally {
	            if (s != null) {
	                s.close();
	            }
	        }
		   
		}
}
