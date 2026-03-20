import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int a, b;
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        primes = new ArrayList<>();

        buildPrimes((int) Math.sqrt(b));

        int[] basePrimes = {2, 3, 5, 7, 11};
        for (int x : basePrimes) {
            if (a <= x && x <= b) {
                sb.append(x).append('\n');
            }
        }

        for (int seed = 10; ; seed++) {
            int palindrome = makeOddPalindrome(seed);

            if (palindrome > b) break;
            if (palindrome < a) continue;

            int lastDigit = palindrome % 10;
            if (lastDigit % 2 == 0 || lastDigit == 5) continue;

            if (digitSum(palindrome) % 3 == 0) continue;

            if (isPrime(palindrome)) {
                sb.append(palindrome).append('\n');
            }
        }

        sb.append(-1).append('\n');
        System.out.print(sb);

    }

    private static int makeOddPalindrome(int seed) {
        int result = seed;
        int x = seed / 10;

        while (x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    private static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    private static void buildPrimes(int limit) {
        boolean[] isComposite = new boolean[limit + 1];

        for (int i = 2; i * i <= limit; i++) {
            if (isComposite[i]) continue;
            for (int j = i * i; j <= limit; j += i) {
                isComposite[j] = true;
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) primes.add(i);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int p : primes) {
            if (p * p > n) break;
            if (n % p == 0) return false;
        }
        return true;
    }

}
