package codejam2017_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringAnagram sa = new stringAnagram();
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input = s.nextLine();
		String output = input.replaceAll("in", "out");
		sa.readfile(input, output);
//		System.out.println(sa.isStringAnagram("anagram", "magran",3) ? "O":"X");;
	}

}
 class stringAnagram{
	 
	 boolean isStringAnagram(String str1, String str2,int D){
		 System.out.println("str1 "+str1+" str2 "+str2 +" d "+D);
		 int len1 = str1.length() , len2 = str2.length();
		 if(len1 != len2) return false;
		 HashMap<Integer,Queue<Integer>> idxOfChar = new HashMap<>();
		 
		 for(int i =0;i<len1;i++){
			 
			 int key =str1.charAt(i)-'a';
			 if(!idxOfChar.containsKey(key)){
				 idxOfChar.put((key),new LinkedList<Integer>());
			 }
			 idxOfChar.get(key).add(i);
			 //System.out.println("key "+key+" i "+i);
		 }
		 
		 
		 for(int j =0;j<len2;j++){
			 int key2 = str2.charAt(j)-'a';
			 //System.out.println("key "+key2+" j "+j);
			 if(!idxOfChar.containsKey(key2)) return false;
			 Queue<Integer> arr = idxOfChar.get(key2);
			 int k = arr.size();
			 while(arr.isEmpty()==false ){
				 int i = arr.peek();
				 if(i-D <= j && j <= i+D){
					 arr.poll();
					 break;
				 }
				 k--;
				 if(k<0) return false;
			 }
		 }
		 
		 return true;
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
					int D = Integer.parseInt(s.nextLine());
					String str1 = s.nextLine();
					String str2 = s.nextLine();
					//System.out.println("count : "+count);
					boolean res = isStringAnagram(str1, str2, D);
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