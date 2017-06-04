package coding_study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int res = -1;
		if(gas == null || gas.length == 0 ||cost == null || cost.length==0) return res;
		int len = gas.length, remainGas=0,curGas=0;
		int[] p = new int[len];
		if(len==1 && (gas[0]>=cost[0])) res = 0;
		for(int i=0;i<len;i++){
			remainGas += gas[i] - cost[i];
			curGas += gas[i] - cost[i];
			if(curGas>=0 ){
				if(res == -1)	res = i;
			}else{
				curGas=0;
				res = -1;
			}
		}
		if(remainGas<0) res = -1;
		return res;
	}
	  void readfile(String path){
	        Scanner s = null;

	        try {
	            s = new Scanner(new BufferedReader(new FileReader(path)));//new InputStreamReader(System.in)))

	        	int nTest = s.nextInt();
	        	System.out.println("number of test case : "+nTest);
	        	for(int testcase=0;testcase<nTest;testcase++){
	            	// int array:  length 1,2,3
	            	int count = s.nextInt();
	            	System.out.println("count : "+count);
	            	int[] gas = new int[count];
	            	int[] cost = new int[count];
	            	for(int i=0;i< count;i++){
	            		 String str= s.next();
	            		 String[] v=str.split(",");
	            		//System.out.println(str+" v[0]:"+v[0]);
	            		gas[i] = Integer.parseInt(v[0]);
	            		cost[i] = Integer.parseInt(v[1]);
	            		//System.out.println("i="+i+"gas:"+gas[i]+"cost:"+cost[i]);
	            	}
	            	int answer = s.nextInt();

	        		//System.out.println("ans"+answer);
	            	long start = System.nanoTime();
	            	int res = canCompleteCircuit(gas, cost);
	            	if(answer != res){
	            		System.out.println("Fail !!! "+testcase+" res :"+res);
	            		
	            	}
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
