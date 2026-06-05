import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        String bomb = br.readLine();

        int n = word.length();
        int b = bomb.length();

        char[] stack = new char[n];
        int top = 0;

        char last = bomb.charAt(b - 1);

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            stack[top++] = ch;

            if (ch == last && top >= b) {
                boolean same = true;

                for (int j = 0; j < b; j++) {
                    if (stack[top - b + j] != bomb.charAt(j)) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    top -= b;
                }
            }
        }

        if (top == 0) {
            sb.append("FRULA");
        } else {
            sb.append(stack, 0, top);
        }

        System.out.println(sb);

    }

}