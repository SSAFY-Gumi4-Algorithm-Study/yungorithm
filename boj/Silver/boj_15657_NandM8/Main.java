import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, resultIdx;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
    	for(int i = 0; i < n; i++) {
    		result = new int[m];
    		result[0] = arr[i];
    		dfs(1);
    	}
        
        System.out.println(sb);
        
    }
    
    public static void dfs(int depth) {
    	if(depth == m) {
    		for(int i = 0; i < m; i++) {
    			sb.append(result[i]).append(' ');   			
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(result[depth - 1] > arr[i]) continue;
    		
    		result[depth] = arr[i];
    		dfs(depth + 1);
    	}
    }
    
}
