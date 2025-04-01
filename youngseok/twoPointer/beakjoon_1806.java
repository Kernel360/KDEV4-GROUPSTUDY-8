package youngseok.twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
부분합 - 골드 4
https://www.acmicpc.net/problem/1806
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중,
가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

start : 시작점
end : 시작점 + 1
minLength : Integer.MAX_VALUE
로직
1. start에서 end의 합이 S 이상인지 확인
    1-1. 합이 s 이상이면 길이를 비교하고 더 짧으면 저장, 길면 start를 한칸 이동
    1-2. 합이 s 미만이면 end를 한칸 이동
2. end와 start가 끝점에 도달하면 종료

입력
10 15
5 1 3 5 10 7 4 9 2 8
출력
2
 */
public class beakjoon_1806 {
	private static int solution(int[] list, int s) {
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		int currentSum = 0;

		for (int end = 0; end < list.length; end++) {
			currentSum += list[end];

			while (currentSum >= s) {
				minLen = Math.min(minLen, end - start + 1);
				currentSum -= list[start];
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int s = Integer.parseInt(stk.nextToken());

		int[] numList = new int[n];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numList[i] = Integer.parseInt(stk.nextToken());
		}

		bw.write(String.valueOf(solution(numList,s)));
		bw.flush();
		bw.close();
		br.close();
	}
}
