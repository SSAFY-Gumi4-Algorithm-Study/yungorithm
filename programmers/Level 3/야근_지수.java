import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long total = 0;
        for (int work : works) {
            total += work;
        }

        if (total <= n)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int cur = pq.poll();
            pq.offer(cur - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            answer += cur * cur;
        }

        return answer;
    }
}