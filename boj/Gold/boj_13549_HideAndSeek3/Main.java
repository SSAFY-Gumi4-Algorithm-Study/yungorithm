import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int MAX = 1_000_000;
	static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        bfs(n, m);
        
        System.out.println(dist[m]);

    }
    
    public static void bfs(int start, int end) {
    	dist = new int[MAX + 1];
    	Arrays.fill(dist, -1);
    	
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	
    	q.offer(start);
    	dist[start] = 0;
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		if(cur == end) {
    			break;
    		}
    		
    		int nx = cur * 2;
    		if(nx <= MAX && (dist[nx] == -1 || dist[nx] > dist[cur])) {
    			dist[nx] = dist[cur];
    			q.offer(nx);
    		}
    		
    		nx = cur - 1;
    		if(nx >= 0 && (dist[nx] == -1 || dist[nx] > dist[cur] + 1)) {
    			dist[nx] = dist[cur] + 1;
    			q.offer(nx);
    		}
    		
    		nx = cur + 1;
    		if(nx <= MAX && (dist[nx] == -1 || dist[nx] > dist[cur] + 1)) {
    			dist[nx] = dist[cur] + 1;
    			q.offer(nx);
    		}
    	}
    }
    
}
