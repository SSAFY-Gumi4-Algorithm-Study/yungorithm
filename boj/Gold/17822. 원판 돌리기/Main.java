import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotateTotal(x, d, k);

            if(!remove()) {
                average();
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result += board[i][j];
            }
        }

        System.out.println(result);

    }

    private static void rotateTotal(int x, int d, int k) {
        for(int i = x - 1; i < n; i += x) {
            rotate(i, d, k);
        }
    }

    private static void rotate(int r, int d, int k) {
        int[] tmp = new int[m];
        k %= m;

        for(int j = 0; j < m; j++) {
            if(d == 0) {
                tmp[(j + k) % m] = board[r][j];
            } else {
                tmp[(j - k + m) % m] = board[r][j];
            }
        }

        board[r] = tmp;
    }

    private static boolean remove() {
        boolean[][] remove = new boolean[n][m];
        boolean found = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) continue;

                int cur = board[i][j];

                int left = (j - 1 + m) % m;
                int right = (j + 1) % m;

                if(board[i][left] == cur) {
                    remove[i][j] = true;
                    remove[i][left] = true;
                    found = true;
                }

                if(board[i][right] == cur) {
                    remove[i][j] = true;
                    remove[i][right] = true;
                    found = true;
                }

                if(i > 0 && board[i - 1][j] == cur) {
                    remove[i][j] = true;
                    remove[i - 1][j] = true;
                    found = true;
                }

                if(i < n - 1 && board[i + 1][j] == cur) {
                    remove[i][j] = true;
                    remove[i + 1][j] = true;
                    found = true;
                }
            }
        }

        if(found) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(remove[i][j]) {
                        board[i][j] = 0;
                    }
                }
            }
        }

        return found;
    }

    private static void average() {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != 0) {
                    sum += board[i][j];
                    count++;
                }
            }
        }

        if(count == 0) return;

        double avg = (double) sum / count;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) continue;

                if(board[i][j] > avg) {
                    board[i][j]--;
                } else if(board[i][j] < avg) {
                    board[i][j]++;
                }
            }
        }
    }

}
