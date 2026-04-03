import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] durability, weight;
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		durability = new int[n];
		weight = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		hit(0, 0);
		
		System.out.println(result);
		
	}
	
	public static void hit(int idx, int cnt) {
		// 이미 모든 계란을 확인한 경우
		if(idx == n) {
			if(result < cnt) {
				result = cnt;
			}
			return;
		}
		
		// 들고 있는 계란이 깨지면 다음으로
		if(durability[idx] <= 0) {
			hit(idx + 1, cnt);
			return;
		}
		
		boolean didHit = false;
		
		for(int i = 0; i < n; i++) {
			if(i == idx || durability[i] <= 0) {
				continue;
			}
			
			didHit = true;
			
			// 계란치기
			durability[i] -= weight[idx];
			durability[idx] -= weight[i];
			
			int broken = 0;
			if(durability[i] <= 0) {
				broken++;
			}
			if(durability[idx] <= 0) {
				broken++;
			}
			
			hit(idx + 1, cnt + broken);
			
			// 원상복구
			durability[i] += weight[idx];
			durability[idx] += weight[i];
			
			if(cnt >= n) {
				result = n;
				return;
			}
		}
		
		if(!didHit) {
			if(result < cnt) {
				result = cnt;
			}
			return;
		}
	}
	
}
