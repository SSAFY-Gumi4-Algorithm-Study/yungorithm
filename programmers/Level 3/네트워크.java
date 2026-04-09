class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int start, int[][] computers) {
        visited[start] = true;
        
        for(int next = 0; next < computers.length; next++) {
            if(!visited[next] && computers[start][next] == 1) {
                dfs(next, computers);
            }
        }
    }
}