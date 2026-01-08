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

        int l = 1;
        int r = 2;

        while(l < r) {
            if(r > 50000) {
                break;
            }

            int diff = r * r - l * l;

            if(diff == n) {
                sb.append(r).append("\n");
                l++;
                r++;
            } else if(diff < n) {
                r++;
            } else {
                l++;
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);

    }

}
