import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Scores implements Comparable<Scores> {
		int paperScore;
		int interviewScore;
		
		public Scores(int paperScore, int interviewScore) {
			this.paperScore = paperScore;
			this.interviewScore = interviewScore;
		}
		
		@Override
		public int compareTo(Scores o) {
			return Integer.compare(this.paperScore, o.paperScore);
		}
	}
	
	static int n;
	static Scores[] score;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			score = new Scores[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				score[i] = new Scores(paper, interview);
			}
			
			Arrays.sort(score);
			
			int result = 1;
			int minInterview = score[0].interviewScore;
			for(int i = 1; i < score.length; i++) {
				if(score[i].interviewScore < minInterview) {
					result++;
					minInterview = score[i].interviewScore;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
