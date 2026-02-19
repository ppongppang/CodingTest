import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();

            int count = 0;
            char prev = '0';
            
            Math.min(count,  0);
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur != prev) {
                    count++;
                    prev = cur;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
