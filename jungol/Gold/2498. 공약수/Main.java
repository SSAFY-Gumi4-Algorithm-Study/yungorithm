import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long target = b / a;

        long resultA = a;
        long resultB = b;

        for(long i = (long) Math.sqrt(target); i >= 1; i--) {
            if(target % i != 0) {
                continue;
            }

            long j = target / i;

            if(gcd(i, j) == 1) {
                resultA = i * a;
                resultB = j * a;
                break;
            }
        }

        System.out.println(resultA + " " + resultB);

    }

    private static long gcd(long a, long b) {
        while(b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

}
