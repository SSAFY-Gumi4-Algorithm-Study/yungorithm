import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int result = right;

        while(left <= right) {
            int mid = (left + right) >> 1;

            if(isPossible(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);

    }

    private static boolean isPossible(int k) {
        int cnt = 1;
        int remain = k;

        for(int i = 0; i < n; i++) {
            if(remain < arr[i]) {
                cnt++;
                remain = k;
            }
            remain -= arr[i];
        }

        return cnt <= m;
    }

}
