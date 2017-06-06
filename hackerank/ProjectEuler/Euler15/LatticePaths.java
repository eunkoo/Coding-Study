package Euler15;

import java.math.BigInteger;
import java.util.Scanner;

public class LatticePaths {


	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		BigInteger[][] dp =new BigInteger[500][500];
		BigInteger  ret = null;;
		for(int i=0;i<T;i++){
			String[] mn = s.nextLine().split(" ");
			int M = Integer.parseInt(mn[0]), N=Integer.parseInt(mn[1]);
			/*   BigInteger Required = factorial(BigInteger.valueOf(n+m)) .divide(factorial(BigInteger.valueOf(n))) .divide(factorial(BigInteger.valueOf(m))) .mod((BigInteger.valueOf(1000000007)));*/
			//System.out.println(Required.toString());

			if(dp[M][N]==null ||( dp[M][N]!=null&& dp[M][N].toString() == "0")){
				for(int j =0;j<=M;j++){
					for(int k=0;k<=N;k++){
						if(j==0 || k==0) dp[j][k] = BigInteger.valueOf(1);
						else dp[j][k] = dp[j-1][k].add( dp[j][k-1] );
					}
				}
			}
			ret = dp[M][N].mod(BigInteger.valueOf(1000000007));
			System.out.println(ret.toString());

		}
	}
	/* static BigInteger factorial(BigInteger n){
        BigInteger ret = new BigInteger("1");
        for(int i=1;i<=n.intValue();i++)
            ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }*/

}
