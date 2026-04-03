import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > 1) pos.add(x);
            else if (x == 1) ones++;
            else if (x == 0) zeros++;
            else neg.add(x);
        }

        pos.sort(Collections.reverseOrder());
        Collections.sort(neg);

        long sum = 0;

        for(int i = 0; i + 1 < pos.size(); i += 2) {
            sum += (long) pos.get(i) * pos.get(i + 1);
        }

        if(pos.size() % 2 == 1) sum += pos.get(pos.size() - 1);

        for(int i = 0; i + 1 < neg.size(); i += 2) {
            sum += (long) neg.get(i) * neg.get(i + 1);
        }

        if(neg.size() % 2 == 1) {
            int leftover = neg.get(neg.size() - 1);
            if (zeros == 0) sum += leftover;
        }

        sum += ones;

        System.out.println(sum);

    }

}
