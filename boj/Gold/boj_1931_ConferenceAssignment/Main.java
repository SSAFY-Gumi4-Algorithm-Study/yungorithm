import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Conference implements Comparable<Conference> {
		int start;
		int end;
		
		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conference o) {
			if(this.end != o.end) return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Conference[] conference = new Conference[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			conference[i] = new Conference(start, end);
		}
		
		Arrays.sort(conference);
		
		int cnt = 0;
		int lastEnd = 0;
		
		for(int i = 0; i < n; i++) {
			if(conference[i].start >= lastEnd) {
				cnt++;
				lastEnd = conference[i].end;
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
