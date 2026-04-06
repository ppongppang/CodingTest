import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main14501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n+2];
        int[] p = new int[n+2];


        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+2];

        for(int i = n; i >= 1; i--) {
            int day = i + t[i];
            dp[i] = dp[i+1];

            if(day <= n+1) {
                dp[i] = Math.max(dp[i], dp[day] + p[i]);
            }
        }

        System.out.println(dp[1]);
    }
}
