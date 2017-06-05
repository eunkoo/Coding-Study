package leetcode_278;

import java.util.Random;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.firstBadVersion(100);
		System.out.println(ret);
		
	}

}
class VersionControl{
	boolean isBadVersion(int ver){
		Random rand = new Random();
		boolean res = rand.nextBoolean();
		System.out.println("ver "+ver+" is "+(res?"bad":"correct"));
		return res;
		
	}
}
class Solution extends VersionControl {
    public int firstBadVersion(int n) {
         int first =1,last=n,ver=1;
        while(first < last){
            ver = first +(last-first)/2;
            
            if(isBadVersion(ver)){
                last = ver;
            }else{
                first = ver+1;
            }
        }
        return first;
    }
}
