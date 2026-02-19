import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution6782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            long n = Long.parseLong(br.readLine());
            int cnt = 0;
            while (n != 2) {
                 long sqrt = (long) Math.sqrt(n);
                 if(sqrt*sqrt == n) {
                     n = sqrt;
                     cnt += 1;
                 } else {
                     long next = (sqrt+1) * (sqrt+1);
                     cnt += (next - n);
                     n = sqrt + 1;
                     cnt ++;
                 }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}