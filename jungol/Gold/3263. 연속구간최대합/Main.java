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

        st = new StringTokenizer(br.readLine());

        long total = 0;

        long currentMax = 0;
        long maxSum = Long.MIN_VALUE;

        long currentMin = 0;
        long minSum = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            int num = Integer.parseInt(st.nextToken());

            total += num;

            if (i == 0) {
                currentMax = num;
                maxSum = num;

                currentMin = num;
                minSum = num;
            } else {
                currentMax = Math.max(num, currentMax + num);
                maxSum = Math.max(maxSum, currentMax);

                currentMin = Math.min(num, currentMin + num);
                minSum = Math.min(minSum, currentMin);
            }
        }

        long result;

        if (total == minSum) {
            result = maxSum;
        } else {
            result = Math.max(maxSum, total - minSum);
        }

        System.out.println(result);

    }

}