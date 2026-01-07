import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.println(k == 0 ? 0 : 1);
            return;
        }

        if(k == 0) {
            System.out.println(0);
            return;
        }

        int maxPos = k + n + 2;
        long[] cur = new long[maxPos];
        long[] next = new long[maxPos];
        for(int i = 0; i < maxPos; i++) {
            cur[i] = 0;
            next[i] = 0;
        }

        cur[k] = 1;

        for(int t = 0; t < n; t++) {
            for(int i = 0; i < maxPos; i++) {
                next[i] = 0;
            }

            for(int pos = 0; pos < maxPos - 1; pos++) {
                if(cur[pos] == 0) continue;

                if(pos - 1 >= 1) {
                    next[pos - 1] += cur[pos];
                }

                next[pos + 1] += cur[pos];
            }

            long[] tmp = cur;
            cur = next;
            next = tmp;
        }

        long result = 0;
        for(int i = 1; i < maxPos; i++) {
            result += cur[i];
        }

        System.out.println(result);

    }

}
