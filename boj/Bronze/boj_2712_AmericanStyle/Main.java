package boj_2712_AmericanStyle;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			double A = Double.parseDouble(st.nextToken());
			String B = st.nextToken();
			double result1 = 0;
			String result2 = "";
			
			switch(B) {
			case "kg":
				result1 = A * 2.2046;
				result2 = "lb";
				break;
			case "lb":
				result1 = A * 0.4536;
				result2 = "kg";
				break;
			case "l":
				result1 = A * 0.2642;
				result2 = "g";
				break;
			case "g":
				result1 = A * 3.7854;
				result2 = "l";
				break;
			}
			
			System.out.printf("%.4f %s", result1, result2);
			System.out.println();
			
		}
		
	}
	
}
