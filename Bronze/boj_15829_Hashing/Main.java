package boj_15829_Hashing;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		long pow = 1;
		
		for(int i = 0 ; i < L; i++) {
			sum += (str.charAt(i) - 96) * pow;
			pow = (pow * 31) % 1234567891;
		}
		
		System.out.println(sum % 1234567891);

	}
	
}
