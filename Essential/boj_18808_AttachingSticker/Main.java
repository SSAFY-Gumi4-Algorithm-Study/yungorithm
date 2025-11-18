import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	static int[][] map;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int s = 0; s < k; s++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	int [][] sticker = new int[r][c];
        	for(int i = 0; i < r; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < c; j++) {
        			sticker[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	boolean flag = false;
        	for(int d = 0; d < 4 && !flag; d++) {
        		int sr = r;
        		int sc = c;
        		
        		for(int i = 0; i <= n - sr && !flag; i++) {
        			for(int j = 0; j <= m - sc && !flag; j++) {
        				if(attachable(sticker, i, j)) {
        					attach(sticker, i, j);
        					flag = true;
        				}
        			}
        		}
        		
        		if(!flag) sticker = rotate(sticker);
        	}
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		result += map[i][j];
        	}
        }
        
        System.out.println(result);
        
    }
    
    public static int[][] rotate(int[][] input) {
    	int r = input.length;
    	int c = input[0].length;
    	
    	int[][] output = new int[c][r];
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			output[j][r - i - 1] = input[i][j];
    		}
    	}
    	
    	return output;
    }
    
    public static boolean attachable(int[][] sticker, int sr, int sc) {
    	int r = sticker.length;
    	int c = sticker[0].length;
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			if(sticker[i][j] == 1) {
    				if(map[sr + i][sc + j] == 1) return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public static void attach(int[][] sticker, int sr, int sc) {
    	int r = sticker.length;
    	int c = sticker[0].length;
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			if(sticker[i][j] == 1) map[sr + i][sc + j] = 1;
    		}
    	}
    }
    
}
