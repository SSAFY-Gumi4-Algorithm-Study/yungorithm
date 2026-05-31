import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        long best = Long.MAX_VALUE;
        int resultL = 0;
        int resultR = 0;

        while (left < right) {
            long sum = (long) arr[left] + arr[right];
            long absSum = Math.abs(sum);

            if (absSum < best) {
                best = absSum;
                resultL = arr[left];
                resultR = arr[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }

        sb.append(resultL).append(" ").append(resultR);
        System.out.println(sb);

    }
}