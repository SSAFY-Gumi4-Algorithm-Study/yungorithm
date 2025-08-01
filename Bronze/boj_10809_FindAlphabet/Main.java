package boj_2920_Notes;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] notes = new int[8];
		for(int i = 0; i < notes.length; i++) {
			notes[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sub = new int[7];
		int[] arr1 = { -1, -1, -1, -1, -1, -1, -1 };
		int[] arr2 = { 1, 1, 1, 1, 1, 1, 1 };
		
		for(int i = 0; i < sub.length; i++) {
			sub[i] = notes[i] - notes[i + 1];
		}
		
		if(Arrays.equals(arr1, sub) == true) {
			System.out.println("ascending");
		} else if(Arrays.equals(arr2, sub) == true) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}
	
}
