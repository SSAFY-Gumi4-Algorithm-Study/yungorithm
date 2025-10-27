import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Fireball {
		int measure;
		int speed;
		int dirc;
		
		public Fireball(int measure, int speed, int dirc) {
			this.measure = measure;
			this.speed = speed;
			this.dirc = dirc;
		}
	}
	
	static int n, m, k;
	static ArrayList<Fireball>[][] map;
	static ArrayList<int[]> list;
	static int[][] direction = { {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1} };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int measure = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dirc = Integer.parseInt(st.nextToken());
			
			map[x - 1][y - 1].add(new Fireball(measure, speed, dirc));
		}
		
		for(int l = 0; l < k; l++) {
			shoot();
			explode();
		}
		
		int result = count();
		
		System.out.println(result);
		
	}
	
	public static void explode() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int size = map[i][j].size();
				if(size < 2) {
					continue;
				}
				
				int mSum = 0;
				int sSum = 0;
				int even = 0;
				int odd = 0;
				
				for(Fireball fb : map[i][j]) {
					mSum += fb.measure;
					sSum += fb.speed;
					if(fb.dirc % 2 == 0) {
						even++;
					} else {
						odd++;
					}
				}
				
				map[i][j].clear();
				
				int m = mSum / 5;
				if(m < 1) {
					continue;
				}
				
				int s = sSum / size;
				int[] dirs = (even == size || odd == size) ? new int[] { 0, 2, 4, 6 } : new int[] { 1, 3, 5, 7 };
				
				for(int d : dirs) {
					map[i][j].add(new Fireball(m, s, d));
				}
			}
		}
	}
	
	public static void shoot() {
		ArrayList<Fireball>[][] next = new ArrayList[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				next[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].isEmpty()) {
					continue;
				}
				
				for(Fireball fb : map[i][j]) {
					int dist = fb.speed % n;
					int x = (i + direction[fb.dirc][0] * dist) % n;
					int y = (j + direction[fb.dirc][1] * dist) % n;
					if(x < 0) {
						x += n;
					}
					if(y < 0) {
						y += n;
					}
					
					next[x][y].add(new Fireball(fb.measure, fb.speed, fb.dirc));
				}
			}
		}
		
		map = next;
	}
	
	public static int count() {
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].isEmpty()) {
					continue;
				}
				
				for(Fireball fb : map[i][j]) {
					sum += fb.measure;
				}
			}
		}
		
		return sum;
	}
	
	public static boolean countSize() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].size() > 1) {
					return true;
				}
			}
		}
		
		return false;
	}

}
