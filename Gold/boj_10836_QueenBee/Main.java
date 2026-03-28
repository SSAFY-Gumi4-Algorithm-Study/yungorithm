import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int toIndex(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int len = 2 * M - 1;
        int[] edge = new int[len];
        Arrays.fill(edge, 1);

        for (int day = 0; day < N; day++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            int idx = zero;

            for (int i = 0; i < one; i++) {
                edge[idx++] += 1;
            }
            for (int i = 0; i < two; i++) {
                edge[idx++] += 2;
            }
        }

        for (int r = 0; r < M; r++) {
            // 첫 번째 열
            sb.append(edge[M - 1 - r]).append(' ');

            // 나머지 열
            for (int c = 1; c < M; c++) {
                sb.append(edge[M - 1 + c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

}
