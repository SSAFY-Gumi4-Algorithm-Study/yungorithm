import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] count = new int[4];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i]]++;
        }

        int[][] wrong = new int[4][4];
        for(int i = 0; i < n; i++) {
            int num;

            if(i < count[1]) {
                num = 1;
            } else if(i < count[1] + count[2]) {
                num = 2;
            } else {
                num = 3;
            }

            int real = arr[i];
            if(num != arr[i]) {
                wrong[num][real]++;
            }
        }

        int result = 0;
        for(int i = 1; i <= 3; i++) {
            for(int j = 1; j <= 3; j++) {
                int swapCnt = Math.min(wrong[i][j], wrong[j][i]);

                result += swapCnt;

                wrong[i][j] -= swapCnt;
                wrong[j][i] -= swapCnt;
            }
        }

        int remain = 0;
        for(int i = 1; i <= 3; i++) {
            for(int j = 1; j <= 3; j++) {
                remain += wrong[i][j];
            }
        }

        result += remain / 3 * 2;

        System.out.println(result);

    }

}
