import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Static {
		public int a = 20;
		static int b = 0;
	}

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i = 0; i < n - 1; i++) {
        	arr[i] = i + 1;
        }
        arr[n - 1] = 997;
        
        sb.append(n).append("\n");
        for(int i = 0; i < n; i++) {
        	sb.append(arr[i]).append(' ');
        }
        
        System.out.println(sb);
        
    }
    
}
