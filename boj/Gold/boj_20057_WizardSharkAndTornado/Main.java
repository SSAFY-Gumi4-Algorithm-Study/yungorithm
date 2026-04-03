import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos {
		int x;
		int y;
		double rate;
		
		public Pos(int x, int y, double rate) {
			this.x = x;
			this.y = y;
			this.rate = rate;
		}
	}
	
	static Pos[] left = {
		new Pos(-2, 0, 0.02), new Pos(2, 0, 0.02), new Pos(-1, 1, 0.01), new Pos(1, 1, 0.01),
		new Pos(-1, 0, 0.07), new Pos(1, 0, 0.07), new Pos(-1, -1, 0.1), new Pos(1, -1, 0.1),
		new Pos(0, -2, 0.05), new Pos(0, -1, 0)
	};
	
	static Pos[] down = {
		new Pos(0, -2, 0.02), new Pos(0, 2, 0.02), new Pos(-1, -1, 0.01), new Pos(-1, 1, 0.01),
		new Pos(0, -1, 0.07), new Pos(0, 1, 0.07), new Pos(1, -1, 0.1), new Pos(1, 1, 0.1),
		new Pos(2, 0, 0.05), new Pos(1, 0, 0)
	};
	
	static Pos[] right = {
		new Pos(-2, 0, 0.02), new Pos(2, 0, 0.02), new Pos(1, -1, 0.01), new Pos(-1, -1, 0.01),
		new Pos(-1, 0, 0.07), new Pos(1, 0, 0.07), new Pos(-1, 1, 0.1), new Pos(1, 1, 0.1),
		new Pos(0, 2, 0.05), new Pos(0, 1, 0)
	};
	
	static Pos[] up = {
		new Pos(0, -2, 0.02), new Pos(0, 2, 0.02), new Pos(1, -1, 0.01), new Pos(1, 1, 0.01),
		new Pos(0, -1, 0.07), new Pos(0, 1, 0.07), new Pos(-1, -1, 0.1), new Pos(-1, 1, 0.1),
		new Pos(-2, 0, 0.05), new Pos(-1, 0, 0)
	};
	
	static int n, sx, sy;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int result = 0;

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        sx = n / 2;
        sy = n / 2;
        
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	if(i % 2 == 0) {
        		move(i, 0);
        		move(i, 1);
        	} else {
        		move(i, 2);
        		move(i, 3);
        	}
        }
        
        System.out.println(result);
        
    }
    
    public static void tornado(Pos[] pos) {
    	int removed = 0;
    	
    	for(Pos p : pos) {
    		int nx = sx + p.x;
    		int ny = sy + p.y;
    		
    		int sand = 0;
    		if(p.rate == 0) {
    			sand = map[sx][sy] - removed;
    		} else {
    			sand = (int)(map[sx][sy] * p.rate);
    		}
    		
    		if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
    			map[nx][ny] += sand;
    		} else {
    			result += sand;
    		}
    		
    		removed += sand;
    	}
    }
    
    public static void move(int cnt, int idx) {
    	for(int i = 0; i <= cnt; i++) {
    		sx += dx[idx];
    		sy += dy[idx];
    		
    		if(sx < 0 || sy < 0) {
    			break;
    		}
    		
    		switch(idx) {
    		case 0:
    			tornado(left);
    			break;
    		case 1:
    			tornado(down);
    			break;
    		case 2:
    			tornado(right);
    			break;
    		case 3:
    			tornado(up);
    			break;
    		}
    	}
    }
    
}
