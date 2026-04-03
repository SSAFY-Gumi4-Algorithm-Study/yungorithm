import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		double[] scores = new double[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			scores[i] = Double.parseDouble(st.nextToken());
		}
		
		Arrays.sort(scores);
		
		double sum = 0.0;
		for(int i = 0; i < N; i++) {
			scores[i] = scores[i] * 100 / scores[N - 1];
			sum += scores[i];
		}
		
		double avg = (double) sum / N;
		System.out.println(avg);
		
	}
	
}
