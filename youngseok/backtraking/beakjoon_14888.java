package youngseok.backtraking;

import java.io.*;
import java.util.StringTokenizer;

/*
연산자 끼워 넣기 - 실버1

N : 숫자의 갯수
N-1 : 연산자의 갯수 (+,-,x,/)

연산은 무조건 앞에서 부터 수열의 순서는 바꿀 수 없다

만들 수 있는 식의 결과가 최대 인 것과 최소인 것을 구하라

입력
1번째 줄 : N
2번째 줄 : 수 배열
3번째 줄 : 연산자의 갯수를 배열로 (+,-,X,/)
 */
public class beakjoon_14888 {
    static int n,maxVal=Integer.MIN_VALUE,minVal=Integer.MAX_VALUE;
    static int[] nums,calcs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            nums[i]=Integer.parseInt(stk.nextToken());
        }
        calcs = new int[4];
        stk = new StringTokenizer(br.readLine());
        for(int i =0;i<4;i++){
            calcs[i]=Integer.parseInt(stk.nextToken());
        }
        solution(nums[0],1);

        bw.write(maxVal+"\n");
        bw.write(String.valueOf(minVal));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calculate(int choice,int a, int b){
        switch (choice) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
            default:
                return 0;
        }
    }

    public static void solution(int currNum,int depth){
        if(depth == n){
            minVal = Math.min(currNum,minVal);
            maxVal = Math.max(currNum,maxVal);
            return;
        }

        for(int i =0;i<4;i++){
            if(calcs[i]>0){
                calcs[i]--;
                solution(calculate(i, currNum, nums[depth]), depth + 1);
                calcs[i]++;
            }
        }
    }
}