import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        int r = 1;

        for(int l = 0; l < n; l++) {
            while(r < n && arr[r] - arr[l] < m) r++;
            if(r == n) break;
            result = Math.min(result, arr[r] - arr[l]);
        }

        System.out.println(result);

    }

}
