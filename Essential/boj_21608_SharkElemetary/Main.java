import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static int[][] map;
	static HashMap<Integer, HashSet<Integer>> student;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n * n];
		map = new int[n][n];
		
		student = new HashMap<>();
		for(int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			
			arr[i] = key;
			student.put(key, new HashSet<>());
			
			for(int j = 0; j < 4; j++) {
				int p1 = Integer.parseInt(st.nextToken());
				student.get(key).add(p1);
			}
		}
		
		for(int i = 0; i < n * n; i++) {
			sortingStudent(arr[i]);
		}
		
		System.out.println(scoring());
		
	}
	
	public static void sortingStudent(int key) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[3] == o2[3]) {
						if(o1[0] == o2[0]) {
							return o1[1] - o2[1];
						}
						
						return o1[0] - o2[0];
					}
					
					return o2[3] - o1[3];
				}
				
				return o2[2] - o1[2];
			}
		});
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int favor = 0;
				int blank = 0;
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					
					if(map[nx][ny] == 0) {
						blank++;
					} else if(student.get(key).contains(map[nx][ny])) {
						favor++;
					}
				}
				
				pq.offer(new int[] { i, j, favor, blank });
			}
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			
			if(map[x][y] == 0) {
				map[x][y] = key;
				break;
			}
		}
	}
	
	public static int scoring() {
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int favor = 0;
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					
					if(map[nx][ny] != 0 && student.get(map[i][j]).contains(map[nx][ny])) {
						favor++;
					}
				}
				
				if(favor > 0) {
					result += Math.pow(10, favor - 1);
				}
			}
		}
		
		return result;
	}

}
