import java.io.*;
import java.util.*;

public class Solution1486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for(int h : arr) {
                for(int s = sum; s >= 0; s--) {
                    if(dp[s]) dp[s + h] = true;
                }
            }

            int answer = Integer.MAX_VALUE;
            for(int s = B; s <= sum; s++) {
                if(dp[s]) {
                    answer = s;
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer - B).append("\n");
        }

        System.out.print(sb);
    }
}
