import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        long xOverlap = Math.min(x2, x4) - Math.max(x1, x3);
        long yOverlap = Math.min(y2, y4) - Math.max(y1, y3);

        if (xOverlap > 0 && yOverlap > 0) {
            sb.append("FACE");
        } else if (xOverlap == 0 && yOverlap == 0) {
            sb.append("POINT");
        } else if ((xOverlap == 0 && yOverlap > 0) || (xOverlap > 0 && yOverlap == 0)) {
            sb.append("LINE");
        } else {
            sb.append("NULL");
        }

        System.out.println(sb);

    }
    
}