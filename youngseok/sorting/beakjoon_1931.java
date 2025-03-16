package youngseok.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
회의실 배정 - 골드 5

n : 회의 갯수

각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾으라
 */
class Combination2 implements Comparable<Combination2> {
    private int start;
    private int end;

    Combination2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Combination2 o) {
        // 종료 시간이 빠른 순으로 정렬 (오름차순)
        if (this.end != o.end) {
            return Integer.compare(this.end, o.end);
        }
        // 종료 시간이 같다면, 시작 시간이 빠른 순으로 정렬 (오름차순)
        return Integer.compare(this.start, o.start);
    }
}

public class beakjoon_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        List<Combination2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            Combination2 combi = new Combination2(start, end);
            list.add(combi);
        }

        Collections.sort(list);
        int currStart = Integer.MIN_VALUE;
        int currEnd = Integer.MIN_VALUE;
        int cnt = 0;

        /*
            combi의 다음 start 가 현재 end보다 같거나 크면 start와 end값을 변경
         */
        for (Combination2 combination2 : list) {
            int start = combination2.getStart();
            int end = combination2.getEnd();
            if (currEnd <= start) {
                currStart = start;
                currEnd = end;
                cnt+=1;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
