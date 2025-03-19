package youngseok.sorting;

/*
두 용액 - 골드 5

투포인터 알고리즘을 사용한 버전
배열의 양 끝 두 숫자의 합을 구하고
해당 값이 양수면 right 를 왼쪽으로,
음수면 left를 오른쪽으로 갱신

이동하면서 가장 작은 절대값을 가지는 조합을 저장

같은 index에 left, right가 만나면 종료
 */

import java.io.*;
import java.util.*;

public class beakjoon_2470_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        int[] potions = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            potions[i]=Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(potions);

        int left = 0,right = n-1,answer1=0,answer2=0,sumVal = Integer.MAX_VALUE;
        while(left!=right){
            int candidate = Math.abs(potions[left]+potions[right]);
            if(sumVal > candidate){
                sumVal = candidate;
                answer1 = potions[left];
                answer2 = potions[right];
            }
            int outcome = potions[left] + potions[right];
            if(outcome > 0){
                right-=1;
            } else if(outcome < 0) {
                left+=1;
            } else {
                break;
            }
        }

        bw.write(answer1 + " " + answer2);
        bw.flush();
        bw.close();
        br.close();
    }
}
