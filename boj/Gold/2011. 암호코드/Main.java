import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        final int MOD = 1000000;

        int n = s.length();

        if(s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0';
            int two = (s.charAt(i - 2) - '0') * 10 + one;

            if(one >= 1 && one <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            if(two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n]);

    }

}
