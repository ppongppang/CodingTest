import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solmagnetic {
		
	static int[][] magnet;
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			int k = Integer.parseInt(br.readLine());
			
			magnet = new int[4][8];
			for(int i=0;i<4;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=0; i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int magIndex = Integer.parseInt(st.nextToken()) -1;
				int rotateDir = Integer.parseInt(st.nextToken());
				
				allMagnetRotate(magIndex, rotateDir);
					
				
			}
			
			int score = 0;
            if (magnet[0][0] == 1) score += 1;
            if (magnet[1][0] == 1) score += 2;
            if (magnet[2][0] == 1) score += 4;
            if (magnet[3][0] == 1) score += 8;
            
            System.out.println("#" + tc + " " + score);
			
		}
		
	}
	
	static void allMagnetRotate(int idx, int dir) {
		int[] directions = new int[4];
		directions[idx] = dir;
		
		for(int i = idx - 1; i >= 0; i--) {
			if(magnet[i][2] != magnet[i+1][6]) {
				directions[i] = -directions[i+1];
			} else {
				break;
			}
		}
		
		for(int i = idx + 1; i < 4; i++) {
			if(magnet[i-1][2] != magnet[i][6]) {
				directions[i] = -directions[i-1];
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
            	oneMagnetRotate(i, directions[i]);
            }
        }
	}
	
	static void oneMagnetRotate(int idx, int dir) {
		if(dir == 1) {
			int temp = magnet[idx][7];
			for(int i=7; i>0; i--) {
				magnet[idx][i] = magnet[idx][i-1];
			}
			magnet[idx][0] = temp;
		}
		
		if(dir == -1) {
			int temp = magnet[idx][0];
			for(int i=0; i < 7; i++) {
				magnet[idx][i] = magnet[idx][i+1];
			}
			magnet[idx][7] = temp;
		}
	}

}
