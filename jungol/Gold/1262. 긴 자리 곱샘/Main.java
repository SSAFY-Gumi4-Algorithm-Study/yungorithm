import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());

            BigInteger n = new BigInteger(st.nextToken());
            if(!st.hasMoreTokens()) {
                break;
            }
            BigInteger m = new BigInteger(st.nextToken());

            sb.append(n.multiply(m)).append('\n');
        }

        System.out.println(sb);

    }

}
