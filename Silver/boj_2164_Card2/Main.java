import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean check[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int i = 0;
		while(q.size() != 1) {
			if(i % 2 == 0) {
				q.poll();
			} else {
				int a = q.peek();
				q.poll();
				q.offer(a);
			}
			i++;
		}
		
		System.out.println(q.poll());
		
	}

}
