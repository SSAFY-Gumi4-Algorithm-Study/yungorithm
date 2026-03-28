import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(st.nextToken());
        int sLen = Integer.parseInt(st.nextToken());

        String w = br.readLine();
        String s = br.readLine();

        int[] target = new int[52];
        int[] window = new int[52];

        for (int i = 0; i < g; i++) {
            target[toIndex(W.charAt(i))]++;
            window[toIndex(S.charAt(i))]++;
        }

        int answer = 0;
        if (isSame(target, window)) answer++;

        for (int i = g; i < sLen; i++) {
            window[toIndex(s.charAt(i - g))]--;
            window[toIndex(s.charAt(i))]++;

            if (isSame(target, window)) answer++;
        }

        System.out.println(answer);
    }

    private static int toIndex(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }

    private static boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 52; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
