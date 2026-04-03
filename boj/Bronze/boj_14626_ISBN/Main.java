import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int sum = 0;
		boolean isEven = false;
		char[] ch = new char[12];
		for(int i = 0; i < 12; i++) {
			ch[i] = str.charAt(i);
			if(ch[i] != '*') {
				if(i % 2 == 0) {
					sum += Character.getNumericValue(ch[i]);
				} else {
					sum += Character.getNumericValue(ch[i]) * 3;
				}
			} else {
				isEven = i % 2 == 0;
			}
		}
		
		int check = Character.getNumericValue(str.charAt(12));
		int result = 10 - sum % 10;
		if(result == 10) {
			result -= 10;
		}
		
		int add = 0;
		while(true) {
			if(check == 0) {
				if(isEven) {
					sb.append(result);
					break;
				} else {
					for(int i = 0; i < 10; i++) {
						if((3 * i) % 10 == result) {
							sb.append(i);
							break;
						}
					}
					break;
				}
			}
			
			if(isEven) {
				if((sum + add) % 10 == 10 - check) {
					sb.append(add);
					break;
				}
			} else {
				if((sum + 3 * add) % 10 == 10 - check) {
					sb.append(add);
					break;
				}
			}
			add++;
		}

		System.out.println(sb.toString());
		
	}

}
