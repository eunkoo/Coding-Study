package leetcode_875;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

class koko {
    public int minEatingSpeed(int[] piles, int H) {
        
        Arrays.sort(piles);
        int len = piles.length;
        int h = piles[len-1], l = 1;
        int m =0;
        while(l < h){
            m = (h+l)/2;
           // System.out.println(" h "+h+" l "+l);
            int sum = 0;
            for(int i=0;i<len;i++){
                sum += piles[i]/m ;
                sum += piles[i]%m>0?1:0;
            }
            if(sum <= H) h = m;
            else    l = m+1;
        }
        return l;
    }
}