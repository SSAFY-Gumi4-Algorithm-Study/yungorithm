import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;

        for (int k = 0; k < layers; k++) {
            int top = k, left = k;
            int bottom = n - 1 - k, right = m - 1 - k;

            int h = bottom - top + 1;
            int w = right - left + 1;
            int len = 2 * (h + w) - 4;

            int rot = r % len;
            if (rot == 0) continue;

            int[] ring = new int[len];
            int idx = 0;

            for (int i = top; i <= bottom; i++) ring[idx++] = arr[i][left];
            for (int j = left + 1; j <= right; j++) ring[idx++] = arr[bottom][j];
            for (int i = bottom - 1; i >= top; i--) ring[idx++] = arr[i][right];
            for (int j = right - 1; j >= left + 1; j--) ring[idx++] = arr[top][j];

            int[] rotated = new int[len];
            for (int i = 0; i < len; i++) {
                rotated[i] = ring[(i - rot + len) % len];
            }

            idx = 0;
            for (int i = top; i <= bottom; i++) arr[i][left] = rotated[idx++];
            for (int j = left + 1; j <= right; j++) arr[bottom][j] = rotated[idx++];
            for (int i = bottom - 1; i >= top; i--) arr[i][right] = rotated[idx++];
            for (int j = right - 1; j >= left + 1; j--) arr[top][j] = rotated[idx++];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
                if (j + 1 < m) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
