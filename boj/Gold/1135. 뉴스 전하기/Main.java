import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        dp = new int[n];

        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                tree[parent].add(i);
            }
        }

        dfs(0);

        System.out.println(dp[0]);

    }

    private static void dfs(int cur) {
        ArrayList<Integer> child = new ArrayList<>();

        for(int next : tree[cur]) {
            dfs(next);
            child.add(dp[next]);
        }

        Collections.sort(child, Collections.reverseOrder());

        int time = 0;
        for(int i = 0; i < child.size(); i++) {
            time = Math.max(time, child.get(i) + i + 1);
        }

        dp[cur] = time;
    }

}


