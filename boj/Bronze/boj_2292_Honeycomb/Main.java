package boj_2292_Honeycomb;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int i;
		int sum = 1;
		
		for(i = 0; i < 18258; i++) {
			sum += 6 * i;
			if(sum >= N) {
				break;
			}
		}
		
		System.out.println(i + 1);
		
	}
	
}
