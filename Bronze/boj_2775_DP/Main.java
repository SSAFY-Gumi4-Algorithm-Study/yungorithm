package boj_2775_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] apt = new int[15][15];			// 최대 14층, 14호까지 있으므로 인덱스 하나 더 만들기
		
		// 0층 초기화
		for(int i = 1; i < 15; i++) {
			apt[0][i] = i;
		}
		
		// 나머지 층 채우기
		for(int k = 1; k < 15; k++) {
			for(int n = 1; n < 15; n++) {
				if(n == 1) {
					apt[k][n] = 1;
				} else {
					apt[k][n] = apt[k][n - 1] + apt[k - 1][n];		// 점화식
				}
			}
		}
		
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(apt[k][n]);
			
		}
	
	}

}
