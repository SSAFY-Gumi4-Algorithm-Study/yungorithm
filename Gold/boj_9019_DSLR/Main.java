import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		String path;
		
		public Node(int v, String path) {
			this.v = v;
			this.path = path;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			int[] prev = new int[10000];
			char[] how = new char[10000];
			Arrays.fill(prev, -1);
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			q.offer(a);
            visited[a] = true;
            prev[a] = a;

            while (!q.isEmpty() && !visited[b]) {
                int cur = q.poll();

                int d = (cur * 2) % 10000;
                if (!visited[d]) {
                    visited[d] = true;
                    prev[d] = cur;
                    how[d] = 'D';
                    q.offer(d);
                }

                int s = (cur == 0) ? 9999 : cur - 1;
                if (!visited[s]) {
                    visited[s] = true;
                    prev[s] = cur;
                    how[s] = 'S';
                    q.offer(s);
                }

                int l = (cur % 1000) * 10 + (cur / 1000);
                if (!visited[l]) {
                    visited[l] = true;
                    prev[l] = cur;
                    how[l] = 'L';
                    q.offer(l);
                }

                int r = (cur / 10) + (cur % 10) * 1000;
                if (!visited[r]) {
                    visited[r] = true;
                    prev[r] = cur;
                    how[r] = 'R';
                    q.offer(r);
                }
            }

            StringBuilder out = new StringBuilder();
            int cur = b;
            while (cur != a) {
                out.append(how[cur]);
                cur = prev[cur];
            }
			
			sb.append(out.reverse()).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
}
