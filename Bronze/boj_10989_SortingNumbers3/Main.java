import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
        	pq.offer(Integer.parseInt(br.readLine()));
        }
        
        for(int i = 0; i < n; i++) {
        	sb.append(pq.poll()).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
}
