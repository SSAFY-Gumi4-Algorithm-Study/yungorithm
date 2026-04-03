import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = n - 1;
        int best = arr[l] + arr[r];
        while(l < r) {
            int sum = arr[l] + arr[r];

            if(Math.abs(sum) < Math.abs(best)) {
                best = sum;
            }

            if(sum > 0) {
                r--;
            } else if(sum < 0) {
                l++;
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(best);

    }

}
