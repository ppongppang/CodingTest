import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Month {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
		
		for(int tc=0; tc < t; tc++) {
			int result = Integer.MIN_VALUE;
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int stoneCount = Integer.parseInt(st.nextToken());
			int[] stonePower = new int[stoneCount];
			
			for(int i = 0; i < stoneCount; i++) {
				int power = Integer.parseInt(st.nextToken());
				stonePower[i] = power;
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < stoneCount; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x-1][y-1] += 1;
				
				for(int j = 1; j <= stonePower[i]; j++) {
					
					for (int d = 0; d < 8; d++) {
						int nx = x + dx[d]*j;
						int ny = y + dy[d]*j;
							
						if(nx >=0 && nx < n && ny >=0 && ny < n) {
							map[nx][ny] +=1;
						}
					}
				}
			}
			
			for (int i= 0; i < n; i++) {
				for (int j=0; j < n; j++) {
					result = Math.max(result, map[i][j]);
				}
			}
			
			sb.append("#" + (tc+1) + " " + result).append("\n"); 
			System.out.println(sb);
		}
				
	}
}


