import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static String s, t;
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		t = br.readLine();
		
		System.out.println(dfs(t) ? 1 : 0);

	}
	
	public static boolean dfs(String str) {
		if(str.length() == s.length()) return str.equals(s);
		if(!set.add(str)) return false;
		
		if(str.charAt(str.length() - 1) == 'A') {
			if(dfs(str.substring(0, str.length() - 1))) return true;
		}
		
		if(str.charAt(0) == 'B') {
			String next = new StringBuilder(str.substring(1)).reverse().toString();
			if(dfs(next)) return true;
		}
		
		return false;
	}

}
