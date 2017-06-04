package codejam2017_5;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;



public class main {
	public static void main(String[] args) {
		wave wrs = new wave();
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input = s.nextLine();
		String output = input.replaceAll("in", "out");
		wrs.readfile(input, output);
//		long r = wrs.move(10, new int[][]{
//			{4, 4},
//			{6, 9},
//			{1, 8},
//			{4, 10},
//			{8, 4},
//			{2, 2},
//			{5, 2},
//			{2, 4},
//			{1, 6},
//			{5, 10}
//			}, new int[][]{
//				{6, 7},
//				{7, 5},
//				{5, 2},
//				{8, 1},
//				{2, 10},
//				{10, 4},
//				{4, 3},
//				{3, 9},
//				{9, 6},
//				{6, 7}});
//		System.out.println("ret : "+ r);
		 long r = wrs.move(6 , new int[][]{{0 ,4},
			{0, 2},
			{1 ,5},
			{1, 0},
			{2, 3},
			{3, 5},
			{4, 1},
			{5, 4},
			{5, 2}},new int[][]{{4, 2},
				{5, 7},
				{1, 2},
				{1, 6},
				{3, 1},
				{2, 1}});
		System.out.println("ret : "+ r);
//		
		
	}
	
}

class wave{

	void print(String s){
//		System.out.println(s);
	}
	BigDecimal pointToLineDistance(Point A, Point B, Point P) {
		BigDecimal atob = BigDecimal.valueOf(Math.sqrt((B.x-A.x)*(B.x-A.x)+(B.y-A.y)*(B.y-A.y)));
		BigDecimal line = BigDecimal.valueOf(Math.abs((P.x-A.x)*(B.y-A.y)-(P.y-A.y)*(B.x-A.x)));		;
	    return line.subtract(atob);
	  }
	BigDecimal distToline(int ax,int ay,int bx,int by, int px,int py){
		double d = Line2D.ptLineDistSq(ax,ay,bx,by,px,py);
		d = Math.min(Math.min(d, Point.distanceSq(ax, ay, px, py)),
				Point.distanceSq(bx, by, px, py));
		return BigDecimal.valueOf(d);
	}
	 boolean isintersectExtLine(int x1, int y1, int x2, int y2){
		 double slope, y3, y4;
		   slope = (y2 - y1)/(x2 - x1);
		   y3 = (slope * (100000 - x1)) + y1;
		   y4 = (slope * (-100000 - x1)) + y1;
		   Point2D out1 = new Point2D.Double(100000, y3);
		   Point2D out2 = new Point2D.Double(-100000, y4);
		   Line2D.Double line = new Line2D.Double(out1, out2);
		   return true;
	 }
	 int[][] extendedLine(Point A, Point B,int n){
		 Point C = new Point();
		 Point D = new Point();
		 double lenAB = Math.sqrt(Math.pow(A.x - B.x, 2.0) + Math.pow(A.y - B.y, 2.0));
		 C.x = (int) (B.x + (B.x - A.x) / lenAB * n);
		 C.y = (int) (B.y + (B.y - A.y) / lenAB * n);
		 D.x = (int) (A.x + (A.x - B.x) / lenAB * n);
		 D.y = (int) (A.y + (A.y - B.y) / lenAB * n);
		 print ("new p1 "+C.x+" "+C.y+" "+D.x+" "+D.y+" ");
		 return new int[][]{{C.x,C.y},{D.x,D.y}};
//		 return C;
	 }
	long move(int n, int[][] gss, int[][] wv){
		int countGss = gss.length;
//		BigDecimal ret = new BigDecimal(0);
		long ret = 0;//new BigDecimal(0);
//		boolean[] lost = new boolean[countGss];
		int[] preWv = new int[]{-1,-1};
//		boolean[][] intrsct = new boolean[countGss][countGss];
		
		int wv_i = 0;
		while(wv_i < wv.length){
			int danGss1 = wv[wv_i][0]-1;
			int danGss2 = wv[wv_i][1]-1;
			boolean error = false;
			print("danger "+danGss1+" danger "+danGss2);
//			print("preWv x "+preWv[0]+" preWv y "+preWv[1]);
			
			if(preWv[0]!=-1&& preWv[1]!=-1){
				if(( preWv[0] == danGss1 && preWv[1] != danGss2) || ( preWv[0] != danGss1 && preWv[1] == danGss2)
						|| (preWv[1] != danGss1 && preWv[0] == danGss2) || (preWv[1] == danGss1 && preWv[0] != danGss2) ){
				}else{
					print("pre pnt "+preWv[1]+" "+preWv[0]);
					wv_i++;
					error = true;
					continue;
				}
			}
			int gss_i = gss.length-1,mov=-1;
			
			for(int i=0;i<countGss;i++){
				if(error)break;
				for(int j=0;j<countGss;j++){
					
					if(error || i==j || danGss1 == j || danGss2 == j || danGss1 == i|| danGss2==i/*|| intrsct[i][j]*/ )continue; 
//					print("i "+i+" j "+j);
//					int[][] newP = extendedLine(new Point(gss[danGss1][0], gss[danGss1][1]),
					//new Point(gss[danGss2][0], gss[danGss2][1]),n*2);
//					if(Line2D.linesIntersect(gss[i][0], gss[i][1], gss[j][0], gss[j][1], 
//							newP[0][0], newP[0][1], newP[1][0], newP[1][1]) ){
					if(Line2D.linesIntersect(gss[danGss1][0], gss[danGss1][1], gss[danGss2][0], gss[danGss2][1]
							, gss[i][0], gss[i][1], gss[j][0], gss[j][1])){
						print("intersection error ");
						error = true;
						break;
					}
				}
			}
			if(error){
				wv_i++;
				continue;
			}
			
			BigDecimal maxDist = new BigDecimal(-1000000000000000d);
			while(gss_i >=0){
//				if(lost[gss_i]) { 
//					gss_i--;
//					continue;
//				}
				
				//ptSegDist ptLineDist
//				BigDecimal dist = BigDecimal.valueOf( 
//						Line2D.ptSegDist(gss[danGss2][0], gss[danGss2][1], 
//								gss[danGss1][0], gss[danGss1][1]
//						, gss[gss_i][0], gss[gss_i][1]));
				BigDecimal dist = distToline(gss[danGss2][0], gss[danGss2][1], 
								gss[danGss1][0], gss[danGss1][1]
						, gss[gss_i][0], gss[gss_i][1]);
//				BigDecimal dist = pointToLineDistance(
//						new Point(gss[danGss1][0], gss[danGss1][1]), new Point(gss[danGss2][0], gss[danGss2][1]),new Point(gss[gss_i][0], gss[gss_i][1]));
				print("gss[gss_i] "+gss_i+" "+dist);
				if(dist.compareTo(maxDist) == 1){
					maxDist = dist;
					mov = gss_i;
				}else if(maxDist.compareTo(dist)==0){
					print("dist equal mov "+(mov+1)+" gss_i "+(gss_i+1));
					if(gss[mov][0] > gss[gss_i][0])	{
						maxDist = dist;
						mov = gss_i;
					}else if((gss[mov][0] == gss[gss_i][0])
							&&(gss[mov][1] > gss[gss_i][1])){
						maxDist = dist;
						mov = gss_i;
					}
				}				
				gss_i--;
			}
			
//			lost[danGss1] =true;
//			lost[danGss2]=true;
//			for(int i=0;i<countGss;i++){
//				intrsct[danGss1][i] = true;
//				intrsct[i][danGss1] = true;
//				intrsct[danGss2][i] = true;
//				intrsct[i][danGss2] = true;
//			}
			
			preWv[0] = danGss1;
			preWv[1] = danGss2;
			
			
//			if(mov < 0){
//				print("mov is -1");
//				wv_i++;
//				continue;
//				
//			}
			
//			ret = ret.add(BigDecimal.valueOf((mov+1)));
			ret += (mov+1);

			print("mov "+(mov+1)+" maximum dist is "+maxDist +" ret "+ret);
			
			wv_i++;
		}
		
		return ret%1000000007;
		//return (ret.remainder(BigDecimal.valueOf(1000000007))).longValue();
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
			
				String[] nkm = s.nextLine().split(" ");
				
				long[] arr = new long[nkm.length];
				int n = Integer.parseInt(nkm[0]);
				int k = Integer.parseInt(nkm[1]);
				int m = Integer.parseInt(nkm[2]);
				int[][] gss = new int[k][2];
				for(int i=0;i<k;i++){
					String[] pnt = s.nextLine().split(" ");
					gss[i][0] = Integer.parseInt(pnt[0]);
					gss[i][1] = Integer.parseInt(pnt[1]);
				}
				int[][] wv = new int[m][2];
				for(int l=0;l<m;l++){
					String[] pnt = s.nextLine().split(" ");
					wv[l][0] = Integer.parseInt(pnt[0]);
					wv[l][1] = Integer.parseInt(pnt[1]);
				}
				//	int m = getMinRange(p);
				//System.out.println("count : "+count);
				long ret = move(n,gss,wv);
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