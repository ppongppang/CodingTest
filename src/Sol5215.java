import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol5215 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n =  Integer.parseInt(st.nextToken());
			int l =  Integer.parseInt(st.nextToken());
			
			int[] score = new int[n];
			int[] cal = new int[n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[l+1];
			
			for(int i = 0; i<n ; i++) {
				for (int j=l; j >= cal[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j-cal[i]] + score[i]); 
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[l]);
		}
		System.out.println(sb);
	}
}
