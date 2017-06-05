package subsetSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.subsetSum(new int[]{3, 5, 16, 8});
		System.out.println(ret);
	}

}
class Solution{
	boolean subsetSum(int[] arr) {
	    Arrays.sort(arr);
	    int sum = 0;
	    for(int x: arr)
	        sum += x;
	    int k = sum/2;
	    if(sum%2==1) return false;
	    boolean res = false;
	    List<Integer> l = new ArrayList<>();
	    for(int j =arr.length-1;j>=0;j--){
	      res |= findTarget(arr,j,k,l);
	        if(res) break;
	    }
	    
//	    for(int x:l)
//	        System.out.print(x+",");
//	    
	    return res;

	}

	boolean findTarget(int[] arr,int last, int k,List<Integer> l){
	   // System.out.println("last:"+last+" k:"+k);
	    int total = 0;
	    // for(int i =0;i<=last;i++)
	    //     total += arr[i];
	    // if(total < k) return false;
	   // int last = idx-1;
	    while(last >=0){
	        int newTarget = k - arr[last];
	        if(newTarget < 0){
	            return false;
	        }else if(newTarget == 0){
	           l.add(arr[last]);
	            return true;
	        }else {
	            if(findTarget(arr,last-1,newTarget,l)){
	                l.add(arr[last]);
	                return true;
	            }else{

	            }
	        }
	        last--;
	    }
	    return false;
	}
}