package youngseok.twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
고냥이 - 골드 4

문자열을 주면 그 중에서 최대 N개의 종류의 알파벳을 가진 연속된 문자만 인식
문자열이 주어졌을 때 이 번역기가 인식할 수 있는 최대 문자열의 길이가 얼마인가

n : 인식할 수 있는 알파벳의 종류의 최대 개수

번역기가 인식할 수 있는 문자열의 최대 길이를 출력

풀이

start = 0
end = 0

list[start] ~ list[end] 까지 알파벳 종류의 개수가 n보다 작으면 end++
같으면 해당 길이를 기록하고 end++
크면 start++
 */

public class beakjoon_16472 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int start = 0,end;
		int[] alphabetCnt = new int[26];
		int maxLen = 0;
		int cnt = 0;

		for(end = 0;end<str.length();end++){
			int index = Character.toLowerCase(str.charAt(end))-'a';

			if(alphabetCnt[index]==0) cnt++;
			alphabetCnt[index]++;

			while(cnt>n){
				index = str.charAt(start)-'a';
				alphabetCnt[index]--;
				if(alphabetCnt[index]==0) cnt--;
				start++;
			}

			maxLen = Math.max(maxLen,end-start+1);
		}

		bw.write(String.valueOf(maxLen));
		bw.flush();
		bw.close();
		br.close();
	}
}
