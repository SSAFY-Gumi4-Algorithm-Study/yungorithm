import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[][] xy = new String[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = st.nextToken();
			xy[i][1] = st.nextToken();
		}
		
		Arrays.sort(xy, new Comparator<String[]>() {
			
			@Override
			public int compare(String[] s1, String[] s2) {
				int y1 = Integer.parseInt(s1[1]);
				int y2 = Integer.parseInt(s2[1]);
				
				if(y1 != y2) {
					return y1 - y2;
				} else {
					int x1 = Integer.parseInt(s1[0]);
					int x2 = Integer.parseInt(s2[0]);
					
					return x1 - x2;
				}
			}
		});
		
		for(int i = 0; i < xy.length; i++) {
			sb.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
