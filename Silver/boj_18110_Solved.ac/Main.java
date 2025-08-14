import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] difficulty = new int[n];
		for (int i = 0; i < n; i++) {
			difficulty[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(difficulty);
		
		int trimmed = (int) Math.round((double) n * 0.15);
		int sum = 0;
		for(int i = trimmed; i < n - trimmed; i++) {
			sum += difficulty[i];
		}
		
		double avg = (double) sum / (n - trimmed * 2);
		
		System.out.println(Math.round(avg));
		
	}

}
