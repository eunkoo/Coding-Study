package codejam2017_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomeNum rn = new RomeNum();
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input = s.nextLine();
		String output = input.replaceAll("in", "out");
		rn.readfile(input, output);
	}
}
class RomeNum{
	Map<Integer,Set<Integer>> kLst = new HashMap<>();
	RomeNum(){
		kLst.put(0,new HashSet<>());
		kLst.put(1,new HashSet<>());
		kLst.put(2,new HashSet<>());
		kLst.put(3,new HashSet<>());
		kLst.get(1).add(1);
		kLst.get(2).add(2);
		kLst.get(2).add(5);
		kLst.get(2).add(10);
		kLst.get(3).add(3);
		kLst.get(3).add(4);
		kLst.get(3).add(6);
		kLst.get(3).add(9);
		kLst.get(3).add(11);
	}
	boolean isPossible(int n , int k){
		//System.out.println(" n "+n+" k "+k);
		return getPossNums(k).contains(n);
	}

	Set<Integer> getPossNums(int k){
		//System.out.println(" k "+k);
		if(kLst.get(k) != null) return kLst.get(k);
		int mid1 = k/2,mid2=k/2;
		if(k%2!=0){
			mid2++; 
		}

		kLst.put(k,new HashSet<>());
		
		//while(mid1 >=0 && mid2 <= k-1){
		while(mid2 - mid1 <4 ){
			Integer[] i1 =  getPossNums(mid1).toArray(new Integer[0]);
			Integer[] i2 = getPossNums(mid2).toArray(new Integer[0]);
			for(int n1 : i1){
				for(int n2 : i2){
					//System.out.println("n1 : "+n1+" n2 "+n2);
					kLst.get(k).add(n1 + n2);
				}
			}
			mid1--;
			mid2++;
		}
		return kLst.get(k);
	}
	
	void readfile(String in, String out){
		Scanner s = null;
		//BufferedWriter writer= null;
		PrintWriter writer = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(in)));//new InputStreamReader(System.in)))

			writer = new PrintWriter(out, "UTF-8");
			//   while (s.hasNextLine()) {
			//the number of testcases
			int nTest = Integer.parseInt(s.nextLine());
			System.out.println("number of test case : "+nTest);
			for(int testcase=0;testcase<nTest;testcase++){
				// int array:  length 1,2,3
				String[] v = s.nextLine().split(" ");
				//System.out.println("count : "+count);
				int num = Integer.parseInt(v[0]);
				int stick = Integer.parseInt(v[1]);

				boolean res = isPossible(num,stick);
				System.out.println(res ? "O":"X");

				writer.println(res ? "O":"X");
				//	            	long start = System.nanoTime();

			}
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if (s != null) {
				s.close();
			}
			if(writer != null){
				writer.close();
			}
		}

	}
}