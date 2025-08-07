import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static boolean check[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			}
		});
		
		for(int i = 0; i < str.length; i++) {
			if(i > 0 && !str[i - 1].equals(str[i])) {
				System.out.println(str[i]);
			} else if(i == 0) {
				System.out.println(str[i]);
			}
		}
		
	}

}
