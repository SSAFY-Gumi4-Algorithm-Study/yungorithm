import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (str.charAt(i) - '0');
        }

        int[] leftStack = new int[64];
        int[] lengthStack = new int[64];
        int top = 0;

        leftStack[top] = 0;
        lengthStack[top] = n;
        top++;

        while (top > 0) {
            top--;

            int left = leftStack[top];
            int length = lengthStack[top];

            int oneCount = prefix[left + length] - prefix[left];

            if (oneCount == 0) {
                sb.append('0');
            } else if (oneCount == length) {
                sb.append('1');
            } else {
                sb.append('-');

                int half = length / 2;

                if (top + 2 > leftStack.length) {
                    leftStack = Arrays.copyOf(leftStack, leftStack.length * 2);
                    lengthStack = Arrays.copyOf(lengthStack, lengthStack.length * 2);
                }

                leftStack[top] = left + half;
                lengthStack[top] = half;
                top++;

                leftStack[top] = left;
                lengthStack[top] = half;
                top++;
            }
        }

        System.out.println(sb);

    }

}
