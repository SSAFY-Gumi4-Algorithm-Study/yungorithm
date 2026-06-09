import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] first = new int[7];
        Arrays.fill(first, -1);

        first[0] = 0;

        int sumMod = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            sumMod = (sumMod + num) % 7;

            if (first[sumMod] == -1) {
                first[sumMod] = i;
            } else {
                result = Math.max(result, i - first[sumMod]);
            }
        }

        System.out.println(result);

    }

}
