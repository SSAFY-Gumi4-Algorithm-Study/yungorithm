import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        int[] indegree = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for(int next : list[cur]) {
                indegree[next]--;

                if(indegree[next] == 0) pq.offer(next);
            }
        }

        System.out.println(sb);

    }

}
