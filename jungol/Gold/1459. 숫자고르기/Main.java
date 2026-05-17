import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited, selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        selected = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(selected[i]) {
                cnt++;
            }
        }

        sb.append(cnt).append("\n");

        for(int i = 1; i <= n; i++) {
            if(selected[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void dfs(int start, int current) {
        if(visited[current]) {
            return;
        }

        visited[current] = true;

        int next = arr[current];

        if(next == start) {
            selected[start] = true;
            return;
        }

        dfs(start, next);
    }

}
