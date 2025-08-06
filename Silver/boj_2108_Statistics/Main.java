import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] cnt = new int[8001];
		int sum = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			cnt[nums[i] + 4000]++;
		}
		
		Arrays.sort(nums);
		
		double avg = (double) sum / N;
		int mid = nums[(N - 1) / 2];
		int mode = 0;
		int range = nums[N - 1] - nums[0];
		
		int max = 0;
		int maxCnt = 0;
		for(int i = 0; i < 8001; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				maxCnt = 1;
			} else if(max == cnt[i]) {
				maxCnt++;
			}
		}
		
		int k = 0;
		int[] result = new int[maxCnt];
		for(int i = 0; i < 8001; i++) {
			if(cnt[i] == max) {
				result[k] = i - 4000;
				k++;
			}
		}
		
		if(maxCnt == 1) {
			mode = result[0];
		} else {
			mode = result[1];
		}
		
		System.out.println(Math.round(avg));
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(range);
		
	}

}
