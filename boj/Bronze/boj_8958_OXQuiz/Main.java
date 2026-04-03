package boj_8958_OXQuiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			
			int score = 0;
			int cnt = 0;
			
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == 'O') {
					cnt++;
					score += cnt;
				} else {
					cnt = 0;
				}
			}
			
			System.out.println(score);
			
		}
		
	}
	
}
