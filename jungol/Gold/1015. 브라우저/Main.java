import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<String> forward = new Stack<>();
        Stack<String> backward = new Stack<>();
        String now = "http://www.acm.org/";

        while(true) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if(command.equals("QUIT")) {
                break;
            }

            if(command.equals("BACK")) {
                if(backward.isEmpty()) {
                    sb.append("Ignored").append('\n');
                } else {
                    forward.push(now);
                    now = backward.pop();
                    sb.append(now).append('\n');
                }
                continue;
            }

            if(command.equals("FORWARD")) {
                if(forward.isEmpty()) {
                    sb.append("Ignored").append('\n');
                } else {
                    backward.push(now);
                    now = forward.pop();
                    sb.append(now).append('\n');
                }
                continue;
            }

            backward.push(now);
            now = st.nextToken();
            forward.clear();
            sb.append(now).append('\n');
        }

        System.out.println(sb);

    }

}
