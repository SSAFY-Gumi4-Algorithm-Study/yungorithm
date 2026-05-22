import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int[] price = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[limit + 1];

        for(int w = 1; w <= limit; w++) {
            for(int i = 0; i < n; i++) {
                if(w >= weight[i]) {
                    dp[w] = Math.max(dp[w], dp[w - weight[i]] + price[i]);
                }
            }
        }

        System.out.println(dp[limit]);

    }
}
