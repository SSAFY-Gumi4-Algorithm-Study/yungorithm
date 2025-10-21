import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] map = new int[101][101];
        
        for(int tc = 0; tc < 4; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for(int i = x1; i < x2; i++) {
        		for(int j = y1; j < y2; j++) {
        			map[i][j] = 1;
        		}
        	}
        }
        
        int cnt = 0;
        for(int i = 0; i < 101; i++) {
        	for(int j = 0; j < 101; j++) {
        		if(map[i][j] == 1) cnt++;
        	}
        }
        
        System.out.println(cnt);
        
    }
    
}
