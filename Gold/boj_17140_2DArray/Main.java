import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int num;
		int cnt;
		
		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
		// 횟수 오름차순 -> 횟수 같으면 수의 오름차순
		@Override
		public int compareTo(Node o) {	
			if(this.cnt == o.cnt) return this.num - o.num;
			return this.cnt - o.cnt;
		}
	}
	
	static int r, c, k, rLength, cLength;
	static int[][] arr = new int[101][101];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(arr[r][c] == k) {
			System.out.println(0);
			return;
		}
		
		rLength = 3;
		cLength = 3;
		
		int time = 0;
		while(time <= 100) {
			if(arr[r][c] == k) break;
			
			time++;
			
			if(rLength >= cLength) rCalc();
			else cCalc();
		}
		
		System.out.println(time > 100 ? -1 : time);

	}
	
	public static void rCalc() {
		int[][] mapCopy = new int[101][101];
		int col = 0;
		
		for(int i = 0; i < rLength; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j = 0; j < cLength; j++) {
				int a = arr[i][j];
				
				if(a == 0) continue;
				
				if(map.containsKey(a)) {
					int value = map.get(a);
					map.replace(a, value + 1);
				} else {
					map.put(a, 1);
				}
			}
			
			ArrayList<Node> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> m : map.entrySet()) {
				list.add(new Node(m.getKey(), m.getValue()));
			}
			
			col = Math.max(col, list.size() * 2);
			Collections.sort(list);
			
			for(int p = 0; p < list.size(); p++) {
				Node node = list.get(p);
				mapCopy[i][p * 2] = node.num;
				mapCopy[i][p * 2 + 1] = node.cnt;
			}
		}
		
		cLength = Math.min(col, 99);
		arr = mapCopy;
	}
	
	public static void cCalc() {
		int[][] mapCopy = new int[101][101];
		int row = 0;
		
		for(int j = 0; j < cLength; j++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < rLength; i++) {
				int a = arr[i][j];
				
				if(a == 0) continue;
				
				if(map.containsKey(a)) {
					int value = map.get(a);
					map.replace(a, value + 1);
				} else {
					map.put(a, 1);
				}
			}
			
			ArrayList<Node> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> m : map.entrySet()) {
				list.add(new Node(m.getKey(), m.getValue()));
			}
			
			row = Math.max(row, list.size() * 2);
			Collections.sort(list);
			
			for(int p = 0; p < list.size(); p++) {
				Node node = list.get(p);
				mapCopy[p * 2][j] = node.num;
				mapCopy[p * 2 + 1][j] = node.cnt;
			}
		}
		
		rLength = Math.min(row, 99);
		arr = mapCopy;
	}

}
