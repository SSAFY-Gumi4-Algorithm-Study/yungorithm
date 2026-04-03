package boj_2869_SnailWannaGoUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int day = Integer.parseInt(st.nextToken());
		int night = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
//		int sum = day;
//		int cnt = 1;
//		while(true) {
//			sum += -night + day;
//			cnt++;
//			if(sum >= height) {
//				break;
//			}
//		}							// 시간 초과
		
		
		int sub = height - day;
		int result = (int) (Math.ceil((double) sub / (day - night))) + 1;
		
		
		System.out.println(result);
	
	}

}
