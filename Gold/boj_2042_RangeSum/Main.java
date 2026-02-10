import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int len = 1;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while(len < n) {
            len <<= 1;
        }

        tree = new long[len * 2];
        for(int i = len; i < len + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        for(int i = len - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        int size = m + k;
        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                update(b - 1, c);
            } else {
                sb.append(get(1, 0, len - 1, b - 1, c - 1)).append('\n');
            }
        }

        System.out.println(sb);

    }

    public static void update(int idx, long val) {
        idx += len;
        tree[idx] = val;

        idx /= 2;
        while(idx > 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx /= 2;
        }
    }

    public static long get(int idx, int s, int e, int ts, long te) {
        if(s > te || e < ts) return 0;
        else if(ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        long l = get(idx * 2, s, mid, ts, te);
        long r = get(idx * 2 + 1, mid + 1, e, ts, te);

        return l + r;
    }

}
