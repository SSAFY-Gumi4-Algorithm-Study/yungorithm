import java.io.*;
import java.util.*;

public class Main {

    static int len;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            if(line.isEmpty()) continue;

            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            len = 1;
            while (len < n) len <<= 1;

            tree = new int[len * 2];
            st = new StringTokenizer(br.readLine());
            for (int i = len; i < len + n; i++) {
                tree[i] = sign(Integer.parseInt(st.nextToken()));
            }

            for (int i = len - 1; i > 0; i--) {
                int val = tree[i * 2] * tree[i * 2 + 1];

                if (val < 0) tree[i] = -1;
                else if (val > 0) tree[i] = 1;
                else tree[i] = 0;
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (oper.equals("C")) {
                    update(a - 1, sign(b));
                } else {
                    int v = get(1, 0, len - 1, a - 1, b - 1);
                    sb.append(getChar(v));
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static int sign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    public static char getChar(int v) {
        if(v < 0) return '-';
        else if(v > 0) return '+';
        else return '0';
    }

    public static void update(int idx, int val) {
        idx += len;
        tree[idx] = val;

        idx >>= 1;
        while(idx > 0) {
            tree[idx] = tree[idx * 2] *  tree[idx * 2 + 1];
            idx >>= 1;
        }
    }

    public static int get(int idx, int s, int e, int ts, int te) {
        if(s > te || e < ts) return 1;
        if(ts <= s && e <= te) return tree[idx];

        int mid = (s + e) >> 1;
        int l = get(idx * 2, s, mid, ts, te);
        int r = get(idx * 2 + 1, mid + 1, e, ts, te);

        return l * r;
    }

}
