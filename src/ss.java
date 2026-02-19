import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ss {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 0 ; tc < 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int op = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < op; i++ ) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < y; j ++) {
					list.add(x+j, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + (tc+1));
			for(int i =0; i <10 ; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
			
		}
	}
	
}
