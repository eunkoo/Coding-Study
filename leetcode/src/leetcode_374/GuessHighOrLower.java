package leetcode_374;

import java.util.Random;

public class GuessHighOrLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution(100);
		int ret = s.guessNumber(100);
		System.out.println(ret);
	}

}
class GuessGame{
	int target = 0;
	public GuessGame(int n){
		
		Random rand = new Random();
		target = rand.nextInt(n);
		System.out.println("target is "+target);
		
	}
	int guess(int m){
		if(m < target) return 1;
		else if(m > target) return -1;
		
		return 0;
	}
}
class Solution extends GuessGame {
	public Solution(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
    public int guessNumber(int n) {
        long l=1,h=n;
        int m =0;
        
        while(l<=h){
            m = (int)(l+(h-l)/2);
            if(guess(m)==0){
                return m;
            }else if(guess(m)>0){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        return m;
    }
}