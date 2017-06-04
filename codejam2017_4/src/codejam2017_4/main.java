package codejam2017_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatSum rs = new RepeatSum();
						Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
						String input = s.nextLine();
						String output = input.replaceAll("in", "out");
						rs.readfile(input, output);


		//		System.out.println((y.add(BigDecimal.valueOf(r)))+" "+(y.add(BigDecimal.valueOf(r))).multiply(BigDecimal.valueOf(p1))+" "+y);

//						System.out.println(" answer : "+rs.getLargeRepeatInfo(new long[]{1, 1, 1, 1, 2}));
//						System.out.println(" answer : "+rs.getLargeRepeatInfo(new long[]{91647, 96625, 90422, 98671, 91144}));
//		System.out.println(" answer : "+rs.getLargeRepeatInfo(new long[]{14, 57 ,57 ,64, 90}));
//		System.out.println(" answer : "+rs.getLargeRepeatInfo(new long[]{911, 267, 768, 382, 458}));

	}

}
class RepeatSum{
	boolean isRepeat(long sum){
		double nr = sum%10;
		while(sum > 0){
			if(sum%10 != nr) return false; 
			sum /= 10;
		}
		return true;
	}
	String makeString(BigDecimal index, int m , int k){
		System.out.println("index "+index+" m "+m+" k "+k);

		return ""+index.remainder(new BigDecimal("1000000007")).toString()+" "+m+"("+k+")";
	}
	String makeString(double index, int m , int k){
		System.out.println("index "+index+" m "+m+" k "+k);

		return ""+(long)index%1000000007+" "+m+"("+k+")";
	}
	String makeString(double index, long sum){
		int c = 0;
		long nr = sum%10;
		while(sum > 0) {
			sum/=10;
			c++;
		}
		System.out.println(index%1000000007+" "+nr+"("+c+")");
		return ""+(long)index%1000000007+" "+nr+"("+c+")";
	}
	int count(long sum){
		int c=0;
		while(sum>0){
			sum/=10;
			c++;
		}
		return c;
	}
	double repeatValue(int pos,int m)
	{
		String str = "";
		while(pos-- > 0){
			str += ""+m;
		}
		return Double.parseDouble(str);
	}
	//	String getLargetRepeatInfo2(long[] arr){

	//		BigDecimal b = new BigDecimal("0");
	//	}
String getLargeRepeatInfo(long[] arr){
		//				for(long n : arr)
		//					System.out.println(n);
		long sum = 0;
		int base = 4, len4=0;
		List<Double> lstS = new ArrayList<>();
		BigDecimal[][] remain = new BigDecimal[10][5];
		BigDecimal[][] tail = new BigDecimal[10][5];
		for(int i=1;i<10;i++)
			for(int j=0;j<5;j++)
				remain[i][j] = BigDecimal.valueOf(i);
		for(int i =0;i<arr.length;i++){
			sum += arr[i];
			if(sum > 10 && isRepeat(sum)) 
				return makeString(i, sum);
			if(i==4)	len4 = count(sum); 
			lstS.add((double) sum);
		}
		
		if(len4 < 3) return getBigDecimalRepeatInfo(arr);
			
		int tar = 0;
		for(int i=0;i<=len4;i++)
			tar += Math.pow(10, i);
		for(int i=1;i<10;i++){
			for(int j=0;j<5;j++){
				tail[i][j] = BigDecimal.valueOf(tar*i-lstS.get(j));
//				System.out.println("tail "+tail[i][j]+" tar "+tar+" lstS.get(j) "+lstS.get(j));
			}
		}

		int pos=0;
		BigDecimal nLoop=new BigDecimal("0");
		while(pos < 100000){
//			System.out.println("pos "+pos+" len4 "+len4);
			//double x = 0;
			BigDecimal x=new BigDecimal("1");//, offset = new BigDecimal("1"), mask = new BigDecimal("1");
			if(len4 > pos ){
				pos++;
				continue;
			} 
			for( int m=1;m<10;m++)
			{ 
				for(int j=0;j<5;j++){
					if(len4 < pos+1){
						
						BigDecimal  left = remain[m][j];//.setScale(1, BigDecimal.ROUND_UNNECESSARY);
//						System.out.println("left "+left+" tail[m][j] "+tail[m][j]);
						BigDecimal rest =BigDecimal.valueOf( 10).pow(len4+1);//.setScale(0, BigDecimal.ROUND_UNNECESSARY);
						rest = rest.multiply(left).add(tail[m][j]);
								//Math.pow(10, len4+1)).multiply(left).add(tail[m][j] );
//						System.out.println("m "+m+ " j "+j+" rest "+" "+rest);
						//System.out.println("after remain "+left.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(m)).doubleValue());
						if(lstS.get(base) < left.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(m)).doubleValue()){
							remain[m][j] =  left.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(m))
									.remainder(BigDecimal.valueOf(lstS.get(base)));//.setScale(0, BigDecimal.ROUND_UNNECESSARY);;
						}
						else
						{
							remain[m][j] =  BigDecimal.valueOf((left.doubleValue()*10+m)%lstS.get(base));
						}
						if( rest.remainder(BigDecimal.valueOf(lstS.get(base))).intValue() != 0) continue;
					}else if( len4 ==pos+1){
						remain[m][j] = BigDecimal.valueOf(m);
						continue;
					}
					for(int k=0;k<=pos;k++)
							x = x.multiply(new BigDecimal("10")).add(new BigDecimal("1"));
						BigDecimal mx = x.multiply(BigDecimal.valueOf(m));
						BigDecimal tbd = mx.subtract(BigDecimal.valueOf(lstS.get(j)));
//						System.out.println("tbd "+ tbd.toString()+" "+BigDecimal.valueOf(lstS.get(j)));
//						if(tbd.remainder( BigDecimal.valueOf(lstS.get(base))).intValue() == 0){
							nLoop = tbd.divide(BigDecimal.valueOf(lstS.get(base))).multiply(BigDecimal.valueOf(5)).add(BigDecimal.valueOf(j));//setScale(0, BigDecimal.ROUND_UNNECESSARY);
	
							System.out.println("nloop :"+nLoop.toString());
							return makeString(nLoop,m,pos+2);
//						}
					
				}
			}

			pos++;
		}
		return " null ";
		//return makeString(index, minimumSub, count);
	}
	String getBigDecimalRepeatInfo(long[] arr){
		//		for(long n : arr)
		//			System.out.println(n);
		long sum = 0;
		int base = 4, len4=0;
		List<Double> lstS = new ArrayList<>();
		int[] remain = new int[9];
		for(int i =0;i<arr.length;i++){
			sum += arr[i];
			if(sum > 10 && isRepeat(sum)) 
				return makeString(i, sum);
			if(i==4)	len4 = count(sum); 
			lstS.add((double) sum);
		}
		for(double n : lstS)
			System.out.println(n);

		int pos=0;
		BigDecimal nLoop=new BigDecimal("0");
		while(pos < 100000){
			//	System.out.println("pos "+pos);
			//double x = 0;
			BigDecimal x=new BigDecimal("1");//, offset = new BigDecimal("1"), mask = new BigDecimal("1");
			int k=0;

			for(;k<=pos;k++)
				x = x.multiply(new BigDecimal("10")).add(new BigDecimal("1"));
			//	for(k=0;k<=pos/2;k++)
			//		mask =  mask.multiply(new BigDecimal("10"));
			//	for(k=0;k<=pos;k++)
			//		offset =  offset.multiply(new BigDecimal("10"));
			//	
			for( int m=1;m<10;m++)
			{ 
				//		BigDecimal maskBd =mask.multiply(BigDecimal.valueOf(m));
				//				System.out.println("mask "+mask);

				BigDecimal mx = x.multiply(BigDecimal.valueOf(m));
				if(mx.subtract(BigDecimal.valueOf(lstS.get(base))).doubleValue() < 1 ) continue;
				//		System.out.println("1 mx "+mx);
				//		if(pos > 10){
				//			mx = mx.divide(offset).setScale(pos/2, BigDecimal.ROUND_DOWN);
				//			maskBd = maskBd.divide(offset).setScale(pos, BigDecimal.ROUND_DOWN);
				//			mx = mx.add(maskBd);
				//		}

				//		System.out.println("2 mx "+mx+" maskBd "+maskBd +" offset "+offset);
				for(int j=0;j<5;j++){
					//System.out.println("value "+(m*x-lstS.get(j)));

					//			if(pos > 10){
					//				mx =mx.setScale(5, BigDecimal.ROUND_DOWN).add(BigDecimal.valueOf(mask));
					//			}
					//.subtract(BigDecimal.valueOf(lstS.get(j))).remainder( BigDecimal.valueOf(lstS.get(base)));
					BigDecimal tbd = mx.subtract(BigDecimal.valueOf(lstS.get(j)));


//					System.out.println("j "+j+" m "+m+" tbd "+ tbd.toString()+" ");
					//			System.out.println("j "+j+" m "+m+" remain "+ tbd.remainder( BigDecimal.valueOf(lstS.get(base))).toString()+" ");
					//			System.out.println(" av "+ tbd.divide( BigDecimal.valueOf(lstS.get(base)),BigDecimal.ROUND_DOWN).toString()+" ");
					//			System.out.println(" ms "+ tbd.divide( BigDecimal.valueOf(lstS.get(base)),BigDecimal.ROUND_DOWN).toString()+" ");
					//					System.out.println( x+" ");
					//System.out.println( tbd.toString()+" "+BigDecimal.valueOf(lstS.get(j)));
					//if((m*x-lstS.get(j))%lstS.get(base)==0){
					
					if(tbd.remainder( BigDecimal.valueOf(lstS.get(base))).intValue() == 0){
						//nLoop = (m*x-lstS.get(j))/lstS.get(base)*5+j;
						//BigDecimal lbd = mx.add(new BigDecimal(-lstS.get(j)));
						//				nLoop = x.multiply(BigDecimal.valueOf(m))
						//						.subtract(BigDecimal.valueOf(lstS.get(j))).divide(BigDecimal.valueOf(lstS.get(base))).setScale(0, BigDecimal.ROUND_UNNECESSARY);
						nLoop = tbd.divide(BigDecimal.valueOf(lstS.get(base))).multiply(BigDecimal.valueOf(5)).add(BigDecimal.valueOf(j));//setScale(0, BigDecimal.ROUND_UNNECESSARY);

						System.out.println("nloop :"+nLoop.toString());
						return makeString(nLoop,m,pos+2);
					}
				}
			}
			pos++;
		}
		return " null ";
		//return makeString(index, minimumSub, count);
	}
	String getRepeatInfo(long[] arr){
		//		for(long n : arr)
		//			System.out.println(n);
		long sum = 0;
		int base = 4, len4=0;
		List<Long> lstS = new ArrayList<>();
		for(int i =0;i<arr.length;i++){
			sum += arr[i];
			if(sum > 10 && isRepeat(sum)) 
				return makeString(i, sum);
			if(i==4)	len4 = count(sum); 
			lstS.add(sum);
		}
		int s_i=0, nLoop=1;

		while(s_i<lstS.size()*2){
			s_i %= lstS.size();
			long lCurSum = lstS.get(base)*nLoop + lstS.get(s_i);
			//			System.out.println("lCurSum : "+lCurSum+" "+s_i +" "+nLoop+" "+lstS.get(s_i));

			if(lCurSum>10 && isRepeat(lCurSum)){
				return makeString(nLoop*5+s_i, lCurSum);
			}
			if(s_i==4)
				nLoop++;
			s_i++;
		}
		return " null ";
		//return makeString(index, minimumSub, count);
	}

	void readfile(String in, String out){
		Scanner s = null;
		//BufferedWriter writer= null;
		PrintWriter writer = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(in)));//new InputStreamReader(System.in)))

			writer = new PrintWriter(out, "UTF-8");
			//   while (s.hasNextLine()) {
			//the number of testcases
			int nTest = Integer.parseInt(s.nextLine());
			System.out.println("number of test case : "+nTest);
			for(int testcase=0;testcase<nTest;testcase++){
				// int array:  length 1,2,3

				String[] input = s.nextLine().split(" ");
				long[] arr = new long[input.length];
				for(int i=0;i<arr.length;i++){
					arr[i] = Long.parseLong(input[i]);
				}
				//	int m = getMinRange(p);
				//System.out.println("count : "+count);
				String ret = getLargeRepeatInfo(arr);
				System.out.println(ret);

				writer.println(ret);
				//	            	long start = System.nanoTime();

			}
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if (s != null) {
				s.close();
			}
			if(writer != null){
				writer.close();
			}
		}
	}
}