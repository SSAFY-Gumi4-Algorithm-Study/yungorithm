import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
    
    public static void main(String[] arlists) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int l = 0;
        int r = n - 1;
        int resultL = 0;
        int resultR = n - 1;
        long best = Long.MAX_VALUE;
        
        while(l < r) {
        	long sum = (long) (arr[l] + arr[r]);
        	long abs = Math.abs(sum);
        	
        	
        	if(abs < best) {
        		best = abs;
        		resultL = l;
        		resultR = r;
        		
        		if(best == 0) break;
        	}
        	
        	if(sum < 0) l++;
        	else r--;
        }
        
        sb.append(arr[resultL]).append(' ').append(arr[resultR]);
        System.out.println(sb);
        
    }
}
