import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc < 11; tc++) {
			int n = Integer.parseInt(br.readLine());
			boolean isValid = true;
			
			for(int i = 0; i< n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				
				boolean isOperator = s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
				
				int tokenCount = st.countTokens();
				
				if(isOperator) {
					if(tokenCount != 2) {
						isValid = false;
					}
				} else {
					if(tokenCount != 0) {
						isValid = false;
					}
				}
			}
			
			sb.append("#" + tc + ' ').append(isValid ? 1 : 0).append("\n");
			
		}
		
		System.out.println(sb);
	}
}

