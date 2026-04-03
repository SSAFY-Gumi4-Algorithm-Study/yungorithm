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
		String[][] regis = new String[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			regis[i][0] = st.nextToken();
			regis[i][1] = st.nextToken();
		}
		
		Arrays.sort(regis, new Comparator<String[]>() {
			// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); 
			}
		});
		
		for(int i = 0; i < regis.length; i++) {
			sb.append(regis[i][0]).append(" ").append(regis[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
