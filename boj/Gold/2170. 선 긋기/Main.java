import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] lines = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int result = 0;

        int start = lines[0][0];
        int end = lines[0][1];

        for(int i = 1; i < n; i++) {
            int nextStart = lines[i][0];
            int nextEnd = lines[i][1];

            if(end < nextStart) {
                result += end - start;
                start = nextStart;
                end = nextEnd;
            } else {
                end = Math.max(end, nextEnd);
            }
        }

        result += end - start;

        System.out.println(result);

    }

}
