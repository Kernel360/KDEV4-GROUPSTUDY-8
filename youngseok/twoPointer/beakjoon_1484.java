package youngseok.twoPointer;

/*
다이어트 - 골드 5

G : 성원이의 현재 몸무게 ^ 2 - 성원이가 기억하고 있던 몸무게의 제곱
성원이의 현재 몸무게로 가능한 것을 모두 출력하라
*/

import java.io.*;

public class beakjoon_1484 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int g = Integer.parseInt(br.readLine());
		boolean found = false;

		int start = 1;
		int end = 1;

		while(end*end - (end-1)*(end-1) <= g) {
			int diff = end*end - start*start;

			if(diff == g) {
				bw.write(end + "\n");
				found = true;
				end++;
			} else if(diff < g) {
				end++;
			} else {
				start++;
			}

			if(end - start == 0) break;
		}

		if(!found) bw.write("-1");
		bw.flush();
		bw.close();
		br.close();
	}
}
