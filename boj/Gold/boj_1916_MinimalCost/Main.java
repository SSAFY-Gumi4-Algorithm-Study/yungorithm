import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m;
    static final int INF = 1_000_000_000;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] finalized;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
        	list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            list[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        System.out.println(dist[end]);
    }

    public static void dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        finalized = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.to;
            int cost = cur.cost;

            if (cost != dist[to]) {
            	continue;
            }

            if (finalized[to]) {
            	continue;
            }
            finalized[to] = true;

            if (to == end) {
            	return;
            }

            for (Node next : list[to]) {
                int v = next.to;
                int nd = cost + next.cost;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Node(v, nd));
                }
            }
        }
    }
}
