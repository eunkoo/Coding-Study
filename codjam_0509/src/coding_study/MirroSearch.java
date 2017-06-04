package coding_study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirroSearch {

	int[][] board = null;
	int[][] score = null;
	Queue<int[]> path = new LinkedList<int[]>();
	boolean[][] visit = null;
	int M, N;

	int findMinWeight(int[][] b, int m, int n) {
		System.out.println("m :" + m + " n: " + n + " b[3][5] " + b[3][5]);
		board = b;
		M = m;
		N = n;
		path = new LinkedList<int[]>();
		path.add(new int[] { 0, 0 });
		score = new int[m][n];
		for (int l = 0; l < M; l++)
			for (int o = 0; o < N; o++)
				score[l][o] = Integer.MAX_VALUE;
		score[0][0] = 1;
		visit = new boolean[m + 1][n + 1];

		return process(0, 0, visit);
	}

	int process(int i, int j, boolean[][] visit) {
		if (i < 0 || j < 0 || i == M || j == N
				|| board[i][j] == 0 /* || visit[i][j] */)
			return 1000000;// Integer.MAX_VALUE;
		else if (i == M - 1 && j == N - 1)
			return 1;

		while (path.isEmpty() == false) {
			int[] pair = path.poll();
			int x = pair[0], y = pair[1];
			visit[x][y] = true;
			if (isBoard(x + 1, y) && board[x + 1][y] != 0) {
				score[x + 1][y] = Math.min(score[x][y] + 1, score[x + 1][y]);
				if (!visit[x + 1][y])
					path.add(new int[] { x + 1, y });
				// System.out.println("x,y : "+x+", "+y+" score[x+1][y]
				// "+score[x+1][y] );
			}
			if (isBoard(x, y + 1) && board[x][y + 1] != 0) {
				score[x][y + 1] = Math.min(score[x][y] + 1, score[x][y + 1]);
				if (!visit[x][y + 1])
					path.add(new int[] { x, y + 1 });
				// System.out.println("x,y : "+x+", "+y+" score[x][y+1]
				// "+score[x][y+1] );
			}
			if (isBoard(x - 1, y) && board[x - 1][y] != 0) {
				score[x - 1][y] = Math.min(score[x][y] + 1, score[x - 1][y]);
				if (!visit[x - 1][y])
					path.add(new int[] { x - 1, y });
				// System.out.println("x,y : "+x+", "+y+" score[x-1][y]
				// "+score[x-1][y] );
			}
			if (isBoard(x, y - 1) && board[x][y - 1] != 0) {
				score[x][y - 1] = Math.min(score[x][y] + 1, score[x][y - 1]);
				if (!visit[x][y - 1])
					path.add(new int[] { x, y - 1 });
				// System.out.println("x,y : "+x+", "+y+" score[x][y-1]
				// "+score[x][y-1] );
			}

		}
		return score[M - 1][N - 1];
	}

	boolean isBoard(int x, int y) {

		return x >= 0 && y >= 0 && x < M && y < N;// && !visit[x][y];
	}

	void readfile(String path) {
		Scanner s = null;

		try {
			s = new Scanner(new BufferedReader(new FileReader(path)));
			// new InputStreamReader(System.in)));//new FileReader(path)));//

			// int nTest = Integer.parseInt(s.nextLine());
			// System.out.println("number of test case : "+nTest);
			// for(int testcase=0;testcase<nTest;testcase++){
			while (s.hasNextLine()) {
				// int array: length 1,2,3
				String line = s.nextLine();
				String[] arr = line.split(" ");
				int m = Integer.parseInt(arr[0]);
				int n = Integer.parseInt(arr[1]);
				int[][] board = new int[m][n];
				for (int i = 0; i < m; i++) {
					line = s.nextLine();
					for (int j = 0; j < n; j++)
						board[i][j] = (int) line.charAt(j) - 48;
				}
				// System.out.println("ans"+answer);
				int res = findMinWeight(board, m, n);
				System.out.println("ans : " + res);
				long start = System.nanoTime();
				// int res = canCompleteCircuit(gas, cost);
				// if(answer != res){
				// System.out.println("Fail !!! "+testcase+" res :"+res);
				//
				// }
				// if(s.hasNextInt())
				// break;
			}
			// }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}

	}
}
