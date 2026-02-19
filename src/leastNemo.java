import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class leastNemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] point = new int[n][3];
		
		for(int i=0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
			point[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		long minArea = Long.MAX_VALUE;
		
		for(int left = 0; left<n;left++) {
			for(int right = left; right <n; right++) {
				int minX = Math.min(point[left][0], point[right][0]);
				int maxX = Math.max(point[left][0], point[right][0]);
				
				int[][] temp = new int[n][3];
                int cnt = 0;
                
                for(int p = 0; p < n; p++) {
                    if(point[p][0] >= minX && point[p][0] <= maxX) {
                        temp[cnt][0] = point[p][0];
                        temp[cnt][1] = point[p][1];
                        temp[cnt][2] = point[p][2];
                        cnt++;
                    }
                }
                
                Arrays.sort(temp, 0, cnt, (a,b) ->a[1] - b[1]);
				
				for(int start = 0; start < cnt; start++) {
					int[] colorCnt = new int[k+1];
					int colorType = 0;
					
					for(int end= start; end < cnt ; end++) {
						int color = temp[end][2];
						if(colorCnt[color] == 0) {
							colorType++;
						}
						colorCnt[color] ++;


						if(colorType == k) {
							int maxY = temp[end][1];
							int minY = temp[start][1];
							long area = (maxX - minX) * (maxY - minY);
							minArea = Math.min(minArea, area);
						}
					}
				}
				
			}
		}
		System.out.println(minArea);
		
	}

}
