import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int n;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				sb.append(0).append("\n");
				continue;
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				map.merge(type, 1, Integer::sum);
			}
			
			ArrayList<Integer> list = new ArrayList<>(map.values());
			
			long result = 1;
			for(Integer value : list) {
				result *= value + 1;
			}
			
			sb.append(result - 1).append("\n");
		}
		
		System.out.println(sb);

	}

}
