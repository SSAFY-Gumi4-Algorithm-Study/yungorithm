import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int n;
	static ArrayList<Long> list;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n <= 10) {
			System.out.println(n);
			return;
		} else if(n >= 1023) {
			System.out.println(-1);
			return;
		}
		
		list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			sol(i);
		}
		
		Collections.sort(list);
		System.out.println(list.get(n));
		
	}
	
	public static void sol(long num) {
		list.add(num);
		long left = num % 10;
		
		if(left == 0) {
			return;
		}
		
		for(long i = left - 1; i >= 0; i--) {
			long tmp = num * 10 + i;
			sol(tmp);
		}
	}

}
