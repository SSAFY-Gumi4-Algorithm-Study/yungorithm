import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t, k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] xArr = new int[t];
        int[] yArr = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        solution(xArr, yArr);
    }

    private static void solution(int[] xArr, int[] yArr) {
        int max = 0;
        int maxX = 0, maxY = 0;

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                int x = xArr[i] + k > n ? n - k : xArr[i];
                int y = yArr[j] + k > m ? m - k : yArr[j];

                int count = getCount(x, y, xArr, yArr);
                if (count > max) {
                    max = count;
                    maxX = x;
                    maxY = y + k;
                }
            }
        }

        sb.append(maxX).append(" ").append(maxY).append("\n");
        sb.append(max);
        
        System.out.println(sb.toString());
    }

    private static int getCount(int x, int y, int[] xArr, int[] yArr) {
        int maxX = x + k;
        int maxY = y + k;
        int count = 0;

        for (int i = 0; i < t; i++) {
            if (x <= xArr[i] && xArr[i] <= maxX && y <= yArr[i] && yArr[i] <= maxY) {
                count++;
            }
        }

        return count;
    }
}
