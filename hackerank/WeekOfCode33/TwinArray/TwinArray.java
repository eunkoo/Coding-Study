package TwinArray;

import java.util.Scanner;

public class TwinArray {

	static int[][] makeMap(int[][] mmap1, int[] ar1){
        mmap1[0][0] = Integer.MAX_VALUE;
        mmap1[1][0] = Integer.MAX_VALUE; 
        for(int i=0;i<ar1.length;i++){
            if(mmap1[0][0] > ar1[i]){
                if(mmap1[1][0] >mmap1[0][0]){
                    mmap1[1][0] = mmap1[0][0];
                    mmap1[1][1] = mmap1[0][1];
                } 
                mmap1[0][0] = ar1[i];
                mmap1[0][1] = i;
            }else if(mmap1[1][0] >ar1[i]){
                mmap1[1][0] = ar1[i];
                mmap1[1][1] = i;
            }
        }
        return mmap1;
    }

    static int twinArrays(int[] ar1, int[] ar2){
        // Complete this function
        int[][] mmap1 = makeMap( new int[2][2], ar1);
        int[][] mmap2 = makeMap( new int[2][2], ar2);     
    
        if(mmap1[0][1] != mmap2[0][1])  return mmap1[0][0]+mmap2[0][0];
        return Math.min(mmap1[0][0] + mmap2[1][0], mmap1[1][0]+mmap2[0][0]);
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        for(int ar1_i = 0; ar1_i < n; ar1_i++){
            ar1[ar1_i] = in.nextInt();
        }
        int[] ar2 = new int[n];
        for(int ar2_i = 0; ar2_i < n; ar2_i++){
            ar2[ar2_i] = in.nextInt();
        }
        int result = twinArrays(ar1, ar2);
        System.out.println(result);
    }

}
