package boj_10809_FindAlphabet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] ch = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		for(int i = 0; i < ch.length; i++) {
			if(alphabet[ch[i] - 97] == -1) {
				alphabet[ch[i] - 97] = i;
			}
		}
		
		for(int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
		
	}
	
}
