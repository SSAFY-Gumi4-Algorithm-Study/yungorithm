import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 2_000_000_001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = n - 1;
        int best = MAX;
        int bestL = 0;
        int bestR = 0;
        while(l < r) {
            int sum = arr[l] + arr[r];

            if(best > Math.abs(sum)) {
                best = Math.abs(sum);
                bestL = arr[l];
                bestR = arr[r];
            }

            if(sum < 0) {
                l++;
                continue;
            } else if(sum > 0) {
                r--;
                continue;
            } else {
                System.out.println(arr[l] + " " + arr[r]);
                return;
            }
        }

        System.out.println(bestL + " " + bestR);

    }

}
