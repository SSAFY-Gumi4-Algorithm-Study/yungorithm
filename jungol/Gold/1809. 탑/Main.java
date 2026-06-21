import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] indexes = new int[n + 1];
        int[] heights = new int[n + 1];

        int top = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (top > 0 && heights[top] < height) {
                top--;
            }

            if (top == 0) {
                sb.append(0).append(' ');
            } else {
                sb.append(indexes[top]).append(' ');
            }

            top++;
            indexes[top] = i;
            heights[top] = height;
        }

        System.out.println(sb);

    }

}
