import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arrow = new int[1000001];

        st = new StringTokenizer(br.readLine());

        int result = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (arrow[h] > 0) {
                arrow[h]--;
            } else {
                result++;
            }

            arrow[h - 1]++;
        }
        
        System.out.println(result);

    }

}