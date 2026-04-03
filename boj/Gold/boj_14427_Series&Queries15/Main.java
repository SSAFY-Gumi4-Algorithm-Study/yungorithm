import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    static final int MAX = 1_000_000_001;
    static int len = 1;
    static Node[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(len < n) len <<= 1;

        tree = new Node[len * 2];
        for(int i = len + n; i < len * 2; i++) {
            tree[i] = new Node(MAX, i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            tree[i + len] = new Node(Integer.parseInt(st.nextToken()), i);
        }

        for(int i = len - 1; i > 0; i--) {
            int a = tree[i * 2].value;
            int b = tree[i * 2 + 1].value;

            if(a <= b) tree[i] = new Node(a, tree[i * 2].idx);
            else tree[i] = new Node(b, tree[i * 2 + 1].idx);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                update(idx - 1, value);
            } else {
                sb.append(tree[1].idx + 1).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static void update(int idx, int  value) {
        idx += len;
        tree[idx].value = value;

        idx >>= 1;
        while(idx > 0) {
            int a = tree[idx * 2].value;
            int b = tree[idx * 2 + 1].value;

            if(a <= b) tree[idx] = new Node(a, tree[idx * 2].idx);
            else tree[idx] = new Node(b, tree[idx * 2 + 1].idx);

            idx >>= 1;
        }
    }

}
