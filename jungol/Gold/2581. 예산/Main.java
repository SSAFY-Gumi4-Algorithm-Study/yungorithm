import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] budgets;
    static int totalBudget;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        budgets = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }

        totalBudget = Integer.parseInt(br.readLine());

        int l = 0;
        int r = max;
        int result = 0;
        while(l <= r) {
            int mid = (l + r) / 2;

            if(canAllocate(mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static boolean canAllocate(int limit) {
        long sum = 0;

        for(int budget : budgets) {
            sum += Math.min(budget, limit);
        }

        return sum <= totalBudget;
    }

}
