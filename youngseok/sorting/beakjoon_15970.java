package youngseok.sorting;

/*
화살표 그리기 - 실버 4

n : 점의 갯수
x : 좌표
y : 색깔

모든 화살표들의 길이 함을 출력하라

풀이

1차로 색깔별로 정렬
2차로 길이순으로 정렬
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Combination implements Comparable<Combination> {
    private final int pos;
    private final int color;

    Combination(int pos, int color) {
        this.pos = pos;
        this.color = color;
    }

    @Override
    public int compareTo(Combination o) {
        if (this.color != o.color) {
            return Integer.compare(this.color, o.color);
        }
        return Integer.compare(this.pos, o.pos);
    }

    public int getPos() {
        return pos;
    }

    public int getColor() {
        return color;
    }
}

public class beakjoon_15970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        List<Combination> combiList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int pos, color;
            pos = Integer.parseInt(stk.nextToken());
            color = Integer.parseInt(stk.nextToken());
            Combination c = new Combination(pos, color);
            combiList.add(c);
        }

        Collections.sort(combiList);
        int sumVal = getSumVal(combiList, n);

        bw.write(String.valueOf(sumVal));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getSumVal(List<Combination> combiList, int n) {
        int sumVal = combiList.get(1).getPos() - combiList.get(0).getPos();
        int candi1, candi2, minNum;
        // 같은 색깔인 경우, 앞 뒤의 점들과의 거리를 비교해 짧은 쪽으로 더해준다.
        for (int i = 1; i < n - 1; i++) {
            Combination prevCombi = combiList.get(i - 1);
            Combination currCombi = combiList.get(i);
            Combination nextCombi = combiList.get(i + 1);

            candi1 = 0;
            candi2 = 0;
            if (nextCombi.getColor() == currCombi.getColor()) {
                candi1 = nextCombi.getPos() - currCombi.getPos();
            }

            if (prevCombi.getColor() == currCombi.getColor()) {
                candi2 = currCombi.getPos() - prevCombi.getPos();
            }

            if (candi1 == 0) {
                minNum = candi2;
            } else if (candi2 == 0) {
                minNum = candi1;
            } else {
                minNum = Math.min(candi1, candi2);
            }

            sumVal += minNum;
        }

        sumVal += combiList.get(n - 1).getPos() - combiList.get(n - 2).getPos();
        return sumVal;
    }
}
