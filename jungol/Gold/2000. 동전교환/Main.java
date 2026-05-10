import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int w = Integer.parseInt(br.readLine());

        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 1; i <= w; i++) {
            for(int coin : coins) {
                if(i - coin < 0) {
                    continue;
                }

                if(dp[i - coin] == INF) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if(dp[w] == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(dp[w]);
        }

    }

}
