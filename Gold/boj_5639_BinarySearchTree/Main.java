import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] prev = new int[100000];
	static int size = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while((line = br.readLine()) != null && !line.isEmpty()) {
			prev[size++] = Integer.parseInt(line);
		}
		
		postOrder(0, size - 1);
    System.out.println(sb);
		
	}
	
	public static void postOrder(int l, int r) {
		if(l > r) return;
		
		int root = prev[l];
		int idx = l + 1;
		while(idx <= r && prev[idx] < root) idx++;
		
		postOrder(l + 1, idx - 1);
		postOrder(idx, r);
		sb.append(root).append("\n");
	}
	
}
