import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, l;
	static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
        	int[] line = new int[n];
        	for(int j = 0; j < n; j++) line[j] = map[i][j];
        	
        	if(checkLine(line)) result++;
        }
        
        for(int j = 0; j < n; j++) {
        	int[] line = new int[n];
        	for(int i = 0; i < n; i++) line[i] = map[i][j];
        	
        	if(checkLine(line)) result++;
        }
        
        System.out.println(result);

    }
    
    public static boolean checkLine(int[] input) {
    	boolean[] used = new boolean[n];
    	
    	for(int i = 0; i < n - 1; i++) {
    		int cur = input[i];
    		int next = input[i + 1];
    		
    		if(cur == next) continue;
    		
    		if(Math.abs(cur - next) > 1) return false;
    		
    		if(cur + 1 == next) {
    			for(int k = i; k > i - l; k--) {
    				if(k < 0) return false;
    				if(input[k] != cur || used[k]) return false;
    				
    				used[k] = true;
    			}
    		} else if(cur - 1 == next) {
    			for(int k = i + 1; k <= i + l; k++) {
    				if(k >= n) return false;
    				if(input[k] != next || used[k]) return false;
    				
    				used[k] = true;
    			}
    		}
    	}
    	
    	return true;
    }

}
