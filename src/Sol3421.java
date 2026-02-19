import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol3421 {
	
	static int n,m;
	static boolean[][] conflict;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			conflict = new boolean[n+1][n+1];
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				conflict[a][b] = true;
				conflict[b][a] = true;
			}
			
			count = 0;
			makeBurger(1, new boolean[n+1]);
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeBurger(int idx, boolean[] ingredient) {
		if(idx == n+1) {
			count++;
			return;
		}
		
		makeBurger(idx+1, ingredient);
		
		boolean canSelect = true;
		
		for(int i=1; i <=idx ; i++) {
			if(ingredient[i] && conflict[i][idx]) {
				canSelect = false;
				break;
			}
		}
		
		if (canSelect) {
			ingredient[idx] = true;
			makeBurger(idx+1, ingredient);
			ingredient[idx] = false;
		}
		
	}
}
