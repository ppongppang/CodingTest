import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol9229 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=t;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] snack = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(snack);
			
			int s = 0;
			int e = n - 1;
			int best = -1;

			while (s < e) {
				int sum = snack[s] + snack[e];

				if (sum > m) {
					e--;
				} else {
					if (sum > best)
						best = sum;
					s++;
				}
			}
			
			sb.append("#" + tc + " " + best).append("\n");
		}
		
		System.out.println(sb);
	}	
}
