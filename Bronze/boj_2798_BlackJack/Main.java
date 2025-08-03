package boj_2798_BlackJack;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] results = new int[N * (N - 1) * (N - 2) / 6];
		int l = 0;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(sum <= M) {
						results[l] = sum;
						l++;
					} else {
						l++;
					}
				}
			}
		}
		
		int max = results[0];
		for(int i = 0; i < results.length; i++) {
			if(results[i] > max) {
				max = results[i];
			}
		}
		
		System.out.println(max);
		
	}
	
}
