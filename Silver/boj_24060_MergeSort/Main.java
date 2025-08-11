import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[] arr;
	static int[] tmp;
	static int result = -1;
	static int cnt;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[a];
		tmp = new int[a];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, a - 1);
		System.out.println(result);
		
	}
	
	public static void mergeSort(int[] arr, int p, int r) {
		if(cnt > k) {
			return;
		}
		
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		
		while(i <= q && j <= r) {
			if(arr[i] < arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		
		while(i <= q) {
			tmp[t++] = arr[i++];
		}
		
		while(j <= r) {
			tmp[t++] = arr[j++];
		}
		
		i = p;
		t = 0;
		while(i <= r) {
			cnt++;
			
			if(cnt == k) {
				result = tmp[t];
				return;
			}
			
			arr[i++] = tmp[t++];
		}
	}
	
}
