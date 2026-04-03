import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			while(n-- > 0) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				
				if(op == 'I') {
					map.put(x, map.getOrDefault(x, 0) + 1);
				} else {
					if(map.isEmpty()) continue;
					
					if(x == 1) {
						int key = map.lastKey();
						int cnt = map.get(key);
						
						if(cnt == 1) map.remove(key);
						else map.put(key, cnt - 1);
					} else {
						int key = map.firstKey();
						int cnt = map.get(key);
						
						if(cnt == 1) map.remove(key);
						else map.put(key, cnt - 1);
					}
				}
			}
			
			if(map.isEmpty()) sb.append("EMPTY\n");
			else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
