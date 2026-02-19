import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];
            dp[0] = 0;

            for(int i = 1; i <= 12; i++) {
                int costDay = dp[i-1] + plan[i] * day;
                int costMonth = dp[i-1] + month;
                dp[i] = Math.min(costDay, costMonth);

                if(i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i-3] + three);
                }
            }
            int ans = Math.min(dp[12], year);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
