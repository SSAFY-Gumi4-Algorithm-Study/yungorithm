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

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> sumN = getSubSums(nArr);
        ArrayList<Long> sumM = getSubSums(mArr);

        Collections.sort(sumM);

        long result = 0;
        for(long a : sumN) {
            long target = t - a;
            int lower = lowerBound(sumM, target);
            int upper = upperBound(sumM, target);
            result += (upper - lower);
        }

        System.out.println(result);

    }

    private static ArrayList<Long> getSubSums(int[] arr) {
        ArrayList<Long> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            long sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }

        return list;
    }

    private static int lowerBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();

        while(left < right) {
            int mid = (left + right) >> 1;
            if(list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int upperBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();

        while(left < right) {
            int mid = (left + right) >> 1;
            if(list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
