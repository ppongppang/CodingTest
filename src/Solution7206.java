import java.io.BufferedReader;
import java.io.IOException;

public class Solution7206 {
    static int[] dp = new int[100000];
    static boolean[] visited = new boolean[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ").append(dfs(n)).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int n){
        if(n < 10) return 0;

        if(visited[n]) return dp[n];

        visited[n] = true;
        String s = Integer.toString(n);
        int L = s.length();
        int best = 0;

        int limit = 1 << (L -1);
        for(int mask =0; mask < limit ; mask++) {
            int prod = 1;
            int cur = 0;

            for(int i = 0; i < L; i++) {
                cur = cur * 10 + (s.charAt(i) - '0');

                if(i == L - 1 || (mask & (1 << i)) != 0) {
                    prod *= cur;
                    cur = 0;
                }
            }
            best = Math.max(best, dfs(prod) + 1);
        }
        dp[n] = best;
        return best;
    }
}
