import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int n;
    static int[] arr;
    static ArrayList<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

		list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer num : list) {
            System.out.println(num);
        }

    }

    public static void dfs(int idx, int target) {
        if(!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx], target);
            visited[arr[idx]] = false;
        }

        if(arr[idx] == target) {
            list.add(idx);
        }
    }
    
}
