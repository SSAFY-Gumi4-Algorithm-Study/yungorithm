package boj_20944_Palindrome;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		
		Arrays.fill(arr,  'a');
		sb.append(arr);
		System.out.println(sb.toString());
		
	}
	
}
