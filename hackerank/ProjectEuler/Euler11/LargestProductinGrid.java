package Euler11;

import java.util.Scanner;

public class LargestProductinGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        double hMax = 0;
        for(int i=0;i<20;i++){
            for(int j=3; j< 20;j++){
                double tMax =  grid[i][j]*grid[i][j-1]*grid[i][j-2]*grid[i][j-3];
                hMax = Math.max(hMax, tMax);
            }
        }
        double vMax = 0;
        for(int j=0; j< 20;j++){
            for(int i=3;i<20;i++){
                double tMax =  grid[i][j]*grid[i-1][j]*grid[i-2][j]*grid[i-3][j];
                vMax = Math.max(vMax, tMax);
            }
        }
        
        double dMax = 0;
        for(int i=0;i<17;i++){
            int m=i,n=0;
            while(m < 17){
                double tMax = grid[m][n]*grid[m+1][n+1]*grid[m+2][n+2]*grid[m+3][n+3];
                dMax = Math.max(dMax,tMax);
                m++;
                n++;
            }
            int k=0,l=i+1;
            while(l<17){
                double tMax = grid[k][l]*grid[k+1][l+1]*grid[k+2][l+2]*grid[k+3][l+3];
                dMax = Math.max(dMax,tMax);
                k++;
                l++;
            }
        }
        for(int i=19;i>=3;i--){
            int m=i,n=0;
            while(m >=3){
                double tMax = grid[m][n]*grid[m-1][n+1]*grid[m-2][n+2]*grid[m-3][n+3];
                dMax = Math.max(dMax,tMax);
                m--;
                n++;
            }
            int k=19,l=i-3;
            while(l<17){
                double tMax = grid[k][l]*grid[k-1][l+1]*grid[k-2][l+2]*grid[k-3][l+3];
                dMax = Math.max(dMax,tMax);
                k--;
                l++;
            }
        }
        System.out.println( (long )Math.max(Math.max(hMax,vMax),dMax) );
    }
}
