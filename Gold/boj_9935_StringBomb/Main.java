import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();

        int n = s.length();
        int m = bomb.length();

        char[] result = new char[n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            result[idx++] = s.charAt(i);

            if(idx >= m) {
                boolean isBomb = true;

                for(int j = 0; j < m; j++) {
                    if(result[idx - m + j] != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb) {
                    idx -= m;
                }
            }
        }

        if(idx == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(new String(result, 0, idx));
        }

    }

}
