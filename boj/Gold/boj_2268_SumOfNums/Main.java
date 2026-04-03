import java.io.*;
import java.util.*;

public class Main {

    static int len = 1;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(len < n) len <<= 1;

        tree = new long[len * 2];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(oper == 0) {
                if(x < y)  sb.append(sum(1, 0, len - 1, x - 1, y - 1)).append("\n");
                else  sb.append(sum(1, 0, len - 1, y - 1, x - 1)).append("\n");
            } else {
                modify(x - 1, y);
            }
        }

        System.out.println(sb);

    }

    public static void modify(int idx, int val) {
        idx += len;
        tree[idx] = val;

        idx >>= 1;
        while(idx > 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx >>= 1;
        }
    }

    public static long sum(int idx, int s, int e, int ts, int te) {
        if(s > te || e < ts) return 0;
        if(ts <= s && e <= te) return tree[idx];

        int mid = (s + e) >> 1;
        long l = sum(idx * 2, s, mid, ts, te);
        long r = sum(idx * 2 + 1, mid + 1, e, ts, te);

        return l + r;
    }

}
