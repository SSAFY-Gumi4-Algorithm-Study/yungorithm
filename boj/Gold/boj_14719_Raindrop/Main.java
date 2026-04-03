import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h;
	static int[][] map;
	static int cnt, result;

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        map = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
        	int height = Integer.parseInt(st.nextToken());
        	int diff = h - height;
        	while(diff < h) {
        		map[diff++][i] = 1;
        	}
        }
        
        result = 0;
        for(int i = 0; i < h; i++) {
        	for(int j = 0; j < w - 1; j++) {
        		if(map[i][j] == 1 && map[i][j + 1] == 0) {
        			cnt = 0;
        			while(true) {
        				j++;
        				if(j == w) break;
        				
        				if(map[i][j] == 1) {
        					result += cnt;
        					j--;
        					break;
        				}
        				cnt++;
        			}
        		}
        	}
        }
        
        System.out.println(result);
        
    }
    
}
