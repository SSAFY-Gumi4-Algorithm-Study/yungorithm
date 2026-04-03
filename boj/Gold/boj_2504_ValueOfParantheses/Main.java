import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static char[] oper;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		oper = br.readLine().toCharArray();
		
		ArrayDeque<Character> q = new ArrayDeque<>();
		int result = 0;
		int multi = 1;
		
		int size = oper.length;
		for(int i = 0; i < size; i++) {
			char ch = oper[i];
			
			if(ch == '(') {
				q.push(ch);
				multi *= 2;
			} else if(ch == '[') {
				q.push(ch);
				multi *= 3;
			} else if(ch == ')') {
				if(q.isEmpty() || q.peek() != '(') {
					System.out.println(0);
					return;
				}
				if(i > 0 && oper[i - 1] == '(') {
					result += multi;
				}
				
				q.poll();
				multi /= 2;
			} else {
				if(q.isEmpty() || q.peek() != '[') {
					System.out.println(0);
					return;
				}
				if(i > 0 && oper[i - 1] == '[') {
					result += multi;
				}
				
				q.poll();
				multi /= 3;
			}
		}
		
		System.out.println(q.isEmpty() ? result : 0);
		
	}
	
}
