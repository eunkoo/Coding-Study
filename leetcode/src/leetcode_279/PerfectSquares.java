package leetcode_279;

import java.util.HashSet;
import java.util.Iterator;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int nSquare = s.numSquares(12);
		System.out.println(nSquare);
	}

}
class Solution {
    public int numSquares(int n) {
        HashSet<Integer> sums = new HashSet<>();
        int  count = 1;
        sums.add(0);
        while(count<=n){
            HashSet<Integer> partial = new HashSet<>();
            for(int i =1;i*i<=n;i++){
                Iterator<Integer> iter = sums.iterator();
                while(iter.hasNext()){
                    Integer sum = (Integer)iter.next();
                    if( sum +i*i < n) partial.add(i*i+sum);
                    else if( sum+i*i == n) return count;
                }
            }
            sums.addAll(partial);
            count++;
        }
        return count;
    }
}