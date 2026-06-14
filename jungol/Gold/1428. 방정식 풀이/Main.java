import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] dp = new int[w + 1];
        int INF = 1_000_000_000;

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 1; i <= w; i++) {
            if(i - a >= 0) {
                dp[i] = Math.min(dp[i], dp[i - a] + 1);
            }

            if(i - b >= 0) {
                dp[i] = Math.min(dp[i], dp[i - b] + 1);
            }

            if(i - c >= 0) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        System.out.println(dp[w]);

    }

}
