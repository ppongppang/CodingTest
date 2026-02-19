import java.io.*;
import java.util.StringTokenizer;


public class SuperCluster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        
        long left = 1L;
        long right = 2_000_000_000L;
        
        while (left <= right) {
        	long mid = left + (right - left + 1) / 2;
        	long cost = 0;
      
        	for(int i=0;i<n;i++) {
        		if(a[i] < mid) {
        			long diff = mid - a[i];
        			cost += diff * diff;
        			if(cost > B) {
        				break;
        			}
        		}
        	}
        	
        	if (B < cost) {
        		right = mid -1;
        	} else {
        		left = mid + 1;
        	}
 
        }
        System.out.println(right);
    }
}