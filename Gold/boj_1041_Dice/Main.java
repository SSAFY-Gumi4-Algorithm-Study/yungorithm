import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        long[] d = new long[6];
        long sum = 0;
        long max = 0;
        long min1 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            d[i] = Long.parseLong(st.nextToken());
            sum += d[i];
            max = Math.max(max, d[i]);
            min1 = Math.min(min1, d[i]);
        }

        if(n == 1) {
            System.out.println(sum - max);
            return;
        }

        long result = getResult(d, n, min1);
        System.out.println(result);

    }

    public static long getResult(long[] d, long n, long min1) {
        int[] opposite = { 5, 4, 3, 2, 1, 0 };

        long min2 = Long.MAX_VALUE;
        for(int i = 0; i < 6; i++) {
            for(int j = i + 1; j < 6; j++) {
                if(opposite[i] == j) continue;

                min2 = Math.min(min2, d[i] + d[j]);
            }
        }

        int[][] corner = {
                {0, 1, 2}, {0, 1, 3}, {0, 4, 2}, {0, 4, 3},
                {5, 1, 2}, {5, 1, 3}, {5, 4, 2}, {5, 4, 3},
        };

        long min3 = Long.MAX_VALUE;
        for(int[] c : corner) {
            min3 = Math.min(min3, d[c[0]] + d[c[1]] + d[c[2]]);
        }

        // 면의 중앙
        long cnt1 = (n - 2) * (n - 2) + 4 * (n - 2) * (n - 1);
        // 모서리
        long cnt2 = 8 * n - 12;
        // 꼭짓점
        long cnt3 = 4;

        return min1 * cnt1 + min2 * cnt2 + min3 * cnt3;
    }

}
