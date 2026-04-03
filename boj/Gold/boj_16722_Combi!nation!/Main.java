import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Card {
        String shape;
        String color;
        String backColor;

        public Card(String shape, String color, String backColor) {
            this.shape = shape;
            this.color = color;
            this.backColor = backColor;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Card[] cards = new Card[10];

        for(int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            cards[i] = new Card(st.nextToken(), st.nextToken(), st.nextToken());
        }

        HashSet<Integer> allHaps = new HashSet<>();
        for(int i = 1; i <= 9; i++) {
            for(int j = i + 1; j <= 9; j++) {
                for(int k = j + 1; k <= 9; k++) {
                    if(isHap(cards[i], cards[j],cards[k])) {
                        allHaps.add(encode(i, j, k));
                    }
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        int result= 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if(oper.equals("G")) {
                if(!flag && set.size() == allHaps.size()) {
                    result +=  3;
                    flag = true;
                } else {
                    result -= 1;
                }
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                int[] arr = {a, b, c};
                Arrays.sort(arr);
                int key = encode(arr[0], arr[1], arr[2]);

                if(!set.contains(key) && allHaps.contains(key)) {
                    result +=  1;
                    set.add(key);
                } else {
                    result -= 1;
                }
            }
        }

        System.out.println(result);

    }

    public static boolean isHap(Card a, Card b, Card c) {
        return pass(a.shape, b.shape, c.shape) && pass(a.color, b.color, c.color) && pass(a.backColor, b.backColor, c.backColor);
    }

    public static boolean pass(String a, String b, String c) {
        return (a.equals(b) && b.equals(c)) || (!a.equals(b) && !b.equals(c) && !c.equals(a));
    }

    public static int encode(int i, int j, int k) {
        return (i << 16) | (j << 8) | k;
    }

}
