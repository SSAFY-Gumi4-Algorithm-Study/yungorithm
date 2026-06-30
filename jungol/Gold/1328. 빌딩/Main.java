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

        int[] heights = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        int[] idx = new int[n + 1];
        int[] stackHeights = new int[n + 1];
        int[] result = new int[n + 1];

        int top = 0;

        for(int i = n; i >= 1; i--) {
            int height = heights[i];

            while(top > 0 && stackHeights[top] <= height) {
                top--;
            }

            if(top == 0) {
                result[i] = 0;
            } else {
                result[i] = idx[top];
            }

            top++;
            idx[top] = i;
            stackHeights[top] = height;
        }

        for(int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

    }

}
