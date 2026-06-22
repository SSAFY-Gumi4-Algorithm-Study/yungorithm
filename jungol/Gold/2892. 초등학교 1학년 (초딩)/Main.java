import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n][21];
        dp[0][nums[0]] = 1;

        for(int i = 1; i < n - 1; i++) {
            for(int value = 0; value <= 20; value++) {
                if(dp[i - 1][value] == 0) continue;

                int plus = value + nums[i];
                int minus = value - nums[i];

                if(plus <= 20) {
                    dp[i][plus] += dp[i - 1][value];
                }

                if(minus >= 0) {
                    dp[i][minus] += dp[i - 1][value];
                }
            }
        }

        System.out.println(dp[n - 2][total]);

    }

}
