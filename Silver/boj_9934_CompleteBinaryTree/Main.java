import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[] inorder, tree;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(br.readLine());
		int size = (1 << k) - 1;
		
		inorder = new int[size];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new int[size + 1];
		dfs(1, 0, size - 1);
		
		for(int depth = 0; depth < k; depth++) {
			int start = 1 << depth;
			int end = 1 << (depth + 1);
			for(int i = start; i < end; i++) {
				sb.append(tree[i]).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int pos, int l, int r) {
		if(l > r) return;
		
		int mid = (l + r) / 2;
		tree[pos] = inorder[mid];
		dfs(pos * 2, l, mid - 1);
		dfs(pos * 2 + 1, mid + 1, r);
	}
	
}
