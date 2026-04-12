import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] map;
    static int[] minDist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        map = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int[] r : roads) {
            map[r[0]].add(r[1]);
            map[r[1]].add(r[0]);
        }
        
        bfs(n, destination);
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            answer[i] = minDist[sources[i]];
        }
        
        return answer;
    }
    
    private static void bfs(int n, int s) {
        minDist = new int[n + 1];
        Arrays.fill(minDist, -1);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        q.offer(s);
        minDist[s] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : map[cur]) {
                if(minDist[next] == -1) {
                    minDist[next] = minDist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
    
}
