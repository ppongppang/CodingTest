import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution4012 {

    static int n;
    static int[][] syn;
    static int[] selected;
    static int minDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            syn = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    syn[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selected = new int[n / 2];
            minDiff = Integer.MAX_VALUE;
            comb(0, 0);

            sb.append('#').append(tc).append(' ').append(minDiff).append('\n');
        }
        System.out.print(sb);

    }

    static void comb(int start, int depth) {
        if (depth == n / 2) {
            calc();
            return;
        }
        for (int i = start; i < n; i++) {
            selected[depth] = i;
            comb(i + 1, depth + 1);
        }
    }

    static void calc() {
        boolean[] isA = new boolean[n];
        for (int i = 0; i < n / 2; i++) {
            isA[selected[i]] = true;
        }

        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isA[i] && isA[j]) {
                    sumA += syn[i][j] + syn[j][i];
                } else if (!isA[i] && !isA[j]) {
                    sumB += syn[i][j] + syn[j][i];
                }
            }
        }

        int diff = Math.abs(sumA - sumB);
        if (diff < minDiff) {
            minDiff = diff;
        }
    }
}
