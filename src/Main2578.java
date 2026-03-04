import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2578 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] callNum = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                callNum[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mark(bingo, callNum[i][j]);

                if (countBingo(bingo) >= 3) {
                    answer = i * 5 + j + 1;
                    break outer;
                }
            }
        }

        System.out.println(answer);
    }

    static void mark(int[][] bingo, int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }

    static int countBingo(int[][] bingo) {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) { rowBingo = false; break; }
            }
            if (rowBingo) count++;

            boolean colBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != 0) { colBingo = false; break; }
            }
            if (colBingo) count++;
        }

        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) { diag1 = false; break; }
        }
        if (diag1) count++;

        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] != 0) { diag2 = false; break; }
        }
        if (diag2) count++;

        return count;
    }
}