import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            int from = e[0];
            int to = e[1];
            list[from].add(to);
            list[to].add(from);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : list[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
