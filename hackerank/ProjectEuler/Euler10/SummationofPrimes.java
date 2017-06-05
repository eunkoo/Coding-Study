package Euler10;

import java.util.Scanner;

public class SummationofPrimes {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(),cnt=0;
        long[] primes = new long[1000000];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long sum=0;
            
            if(cnt > 0 && primes[cnt-1] > n){
                for(int j=0;j<cnt;j++){
                    if(primes[j] > n) break;
                    sum+= primes[j];
                }
                System.out.println(sum);
                continue;
            }
            int i=0,m= cnt ==0 ?2:(int)(primes[cnt-1]+1);
            while(m <= n){
                i=0;
                boolean find = true;
                while(i<cnt && primes[i]*primes[i] <=m ){
                    if(m%primes[i]==0){
                        find = false;
                        break;
                    }
                    i++;
                }
                if(find){
                    primes[cnt++] = m;
                    //sum += m;
                } 
                m++;
            }
            for(long x : primes)
                sum+=x;
            System.out.println(sum);
        }
    }
}
