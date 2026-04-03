import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
    static int n, m;
    static ArrayList<Integer>[] personToParty, partyToPerson;
    static boolean[] known, visPerson, contaminatedParty;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        known = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            int x = Integer.parseInt(st.nextToken());
            known[x] = true;
        }
        
        if (l == 0) {
            System.out.println(m);
            return;
        }

        personToParty = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
        	personToParty[i] = new ArrayList<>();
        }
        
        partyToPerson = new ArrayList[m + 1];
        for(int i = 1; i <= m; i++) {
        	partyToPerson[i] = new ArrayList<>();
        }

        for (int t = 1; t <= m; t++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int p = Integer.parseInt(st.nextToken());
                personToParty[p].add(t);
                partyToPerson[t].add(p);
            }
        }

        visPerson = new boolean[n + 1];
        contaminatedParty = new boolean[m + 1];
        bfs();

        int canLie = 0;
        for (int t = 1; t <= m; t++) {
            if (!contaminatedParty[t]) canLie++;
        }
        System.out.println(canLie);
    }
    
    public static void bfs() {
    	ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int p = 1; p <= n; p++) {
            if (known[p]) {
                visPerson[p] = true;
                q.offer(p);
            }
        }

        while (!q.isEmpty()) {
            int curP = q.poll();

            for (int party : personToParty[curP]) {
                if (!contaminatedParty[party]) {
                    contaminatedParty[party] = true;
                    
                    for (int np : partyToPerson[party]) {
                        if (!visPerson[np]) {
                            visPerson[np] = true;
                            q.offer(np);
                        }
                    }
                }
            }
        }
    }
}
