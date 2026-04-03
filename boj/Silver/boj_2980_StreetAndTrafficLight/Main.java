import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, l;
	static int d, r, g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        int time = 0;
        int pre = 0;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	d = Integer.parseInt(st.nextToken());
        	r = Integer.parseInt(st.nextToken());
        	g = Integer.parseInt(st.nextToken());
        	
        	time += d - pre;
        	pre = d;
        	
        	int red = time % (r + g);
        	if(red <= r) {
        		time += r - red;
        	}
        }
        
        time += l - pre;
        
        System.out.println(time);
        
    }
    
}
