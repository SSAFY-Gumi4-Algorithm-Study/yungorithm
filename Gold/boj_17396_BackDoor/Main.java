import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edliste {
        int to;
        long w;
        
        Edliste(int t, long w) {
        	this.to = t;
        	this.w = w;
        }
    }
    
    static class Node implements Comparable<Node> {
        int v;
        long d;
        
        Node(int v, long d) {
        	this.v = v;
        	this.d = d;
        }
        
        public int compareTo(Node o) {
        	return Long.compare(this.d, o.d);
        }
    }
    
    public static void main(String[] arlists) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] watch = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	watch[i] = Integer.parseInt(st.nextToken());
        }

        List<Edliste>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
        	list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            
            if ((watch[a] == 1 && a != n-1) || (watch[b] == 1 && b != n-1)) continue;
            
            list[a].add(new Edliste(b, w));
            list[b].add(new Edliste(a, w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        if (watch[0] == 1 && 0 != n-1) {
            System.out.println(-1);
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Node(0, 0));

        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            
            if (cur.v == n-1) break;
            
            for (Edliste e : list[cur.v]) {
                if (visited[e.to]) continue;
                
                long nd = cur.d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new Node(e.to, nd));
                }
            }
        }

        System.out.println(dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1]);
    }
}
