package coding_study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JumpGame {
	
	public  boolean canJump(int[] nums) {
	   if(nums == null | nums.length<=1) return true;
       boolean res = true;
       
       int len = nums.length, max = -1;
       for(int i=0;i<len-1;i++){
    	   if((0==nums[i]) && (max<=i)) return false;
    	   max = Math.max(max, nums[i]+i);
       }
       return res;
    } 
	
	  void readfile(String path){
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(path)));//new InputStreamReader(System.in)))

         //   while (s.hasNextLine()) {
            	//the number of testcases
        	int nTest = s.nextInt();
        	System.out.println("number of test case : "+nTest);
        	for(int testcase=0;testcase<nTest;testcase++){
            	// int array:  length 1,2,3
            	int count = s.nextInt();
            	//System.out.println("count : "+count);
            	int[] arr = new int[count];
            	for(int i=0;i< count;i++){
            		arr[i] = s.nextInt();
            	}
            	boolean answer = s.nextBoolean();

        		//System.out.println("ans"+answer);
            	long start = System.nanoTime();
            	if(canJump(arr)!=answer){
	            	System.out.println("Fail case "+testcase+" : "+canJump(arr));
	            	long time = System.nanoTime() - start;
	            	System.out.println("time : "+time);
            	}
            	// string array : length a,b,c,d
            	// int
            	// string
            	
            	
//            	if(s.hasNextInt()){ 		// int
//            		System.out.println("int : "+s.nextInt());
//            	}else if(s.hasNextByte()){ 	// char
//            		System.out.println("char : " + s.nextByte());
//            	}else{ 						// string
//            		System.out.println("string : " +s.next());
//            	}
            	if(s.hasNextLine())
            		s.nextLine();
        	}
           // }
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally {
            if (s != null) {
                s.close();
            }
        }
	   
	}
}
