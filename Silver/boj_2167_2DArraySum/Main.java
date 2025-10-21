import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
        	}
        }
        
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	sb.append(arr[x][y] - arr[a - 1][y] - arr[x][b - 1] + arr[a - 1][b - 1]).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
}
