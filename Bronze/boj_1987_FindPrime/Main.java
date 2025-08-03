package boj_1987_FindPrime;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			boolean isPrime = true;
			
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				continue;
			}
			
			for(int i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
}
