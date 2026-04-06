import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10163 {
    static int[][] map = new int[1001][1001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][4];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            paper[i][0] = Integer.parseInt(st.nextToken());
            paper[i][1] = Integer.parseInt(st.nextToken());
            paper[i][2] = Integer.parseInt(st.nextToken());
            paper[i][3] = Integer.parseInt(st.nextToken());

            for(int x = paper[i][0] ; x < paper[i][0] + paper[i][2]; x++) {
                for(int y = paper[i][1] ; y < paper[i][1] + paper[i][3]; y++) {
                    map[x][y] = i+1;
                }
            }
        }
        int[] area = new int[n];
        for(int x = 0; x < 1001; x++) {
            for(int y = 0; y < 1001; y++) {
                int count = map[x][y];
                if(count != 0) {
                    area[count-1]++;
                }

            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(area[i]);
        }

    }
}
