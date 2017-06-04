package codejam2017_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tour tour = new Tour();
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input = s.nextLine();
		String output = input.replaceAll("in", "out");
		tour.readfile(input, output);
//						System.out.println("r = "+tour.getMinRange(new int[]{1}));
	}
}
class Tour{
	boolean forward(int[] p, boolean[] visit, int index, boolean go, int r){

		boolean res = false;
		visit[index] = true;
		if(index == 0&&!go){
			return true;
		}
		visit[index] = index==0?false: true;
		if(index == p.length-1) {
			go = !go;
		}
		int k=0;
		if(go){ 
			k = index+1;
			while(k<p.length && (p[index]+r) >= (p[k]-r) )	k++;
			for(int l = k-1;l>=index+1;l--){
				if(visit[l]) continue;
				//				System.out.println("p[index]+r "+(p[index]+r)+" p[l]-r  "+(p[l]-r ));
				res |= forward(p,visit,l,go,r);
				if(res)	break;
			}

		}else{
			k = index-1;
			while(k>=0 && p[index]-r <= p[k]+r)	k--;
			for(int l=k+1;l<index;l++){
				if(visit[l]) continue;
				//					System.out.println("p[index]-r "+(p[index]-r)+" p[k]+r  "+(p[l]+r ));
				res |= forward(p,visit,l,go,r);
				if(res)	break;
			}
		}
		return res;
	}
	int getMinRange(int[] p){

		boolean[] visit = new boolean[p.length];
		Arrays.fill(visit, false);
		Arrays.sort(p);
		int maxDiff = 0, minDiff=1000000000;
		for(int i=1;i<p.length;i++){
			maxDiff = Math.max(maxDiff, p[i] - p[i-1]);
			minDiff = Math.min(minDiff, p[i] - p[i-1]);
		}

		
		boolean ret = false;
		int start = maxDiff/2-1 > 0 ? maxDiff/2-1 : 0;
		int end = maxDiff;
		System.out.println("start"+start +" end "+end);
		
		for(int r=start;r<=end;r++){
			Arrays.fill(visit, false);
			//ret |= forward(p,visit,0,true,r);
			int index = 0;
			boolean go = true;
			while(!ret){
//				System.out.println("index "+index+" r "+r+" go "+go);
				
//				for(boolean v : visit)
//					System.out.print(" "+v);
//				System.out.println();
				//boolean res = false;
				visit[index] = true;
				if(index == 0&& !go){
					ret = true; 
					break;
					//return true;
				}
				visit[index] = index==0?false: true;
				if(index == p.length-1) {
					go = !go;
				}
				int k=0;
				if(go){ 
					k = index+1;
					while(k<p.length && (p[index]+r) >= (p[k]-r) )	k++;
					int l = k-1;
					for(;l>=index+1;l--){
						if(visit[l]) continue;
						break;
					}
//					System.out.println("go index "+index+"k "+k+" l "+l);
					if(l==index) {
						if(k < p.length-1){
//							System.out.println("go  p[index] "+(p[index])+" p[k+1]  "+(p[k+1] ));
							r=(p[k+1]-p[index])/2-1 > r ? (p[k+1]-p[index])/2-1:r;
						}
						break;
					}
					index=l;
					continue;
						//				System.out.println("p[index]+r "+(p[index]+r)+" p[l]-r  "+(p[l]-r ));
						//res |= forward(p,visit,l,go,r);
						//index = l;
						
//						if(res)	break;
					//}

				}else{
					k = index-1;
					while(k>=0 && p[index]-r <= p[k]+r)	k--;
					k++;
					int l=k;
					for(;l<index;l++){
						if(visit[l]) continue;
						break;
					}
//					System.out.println("back index "+index);
					if(l==index) {
						if(k>0){
//						System.out.println(" back p[index] "+(p[index])+" p[k-1]  "+(p[k-1] ));
						r= r > (p[index]-p[k-1])/2-1 ? r : (p[index]-p[k-1])/2-1;
						}
						break;
					}
					index=l;
					continue;
						//					System.out.println("p[index]-r "+(p[index]-r)+" p[k]+r  "+(p[l]+r ));
//						res |= forward(p,visit,l,go,r);
						
						
//						if(res)	break;
					//}
				}
			}

			if(ret) return r;
		}
		return maxDiff;
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
				int N = Integer.parseInt(s.nextLine());
				int[] p = new int[N];
				for(int i=0;i<N;i++){
					p[i] = Integer.parseInt(s.nextLine());
				}
				int m = getMinRange(p);
				//System.out.println("count : "+count);

				System.out.println(m);

				writer.println(m);
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