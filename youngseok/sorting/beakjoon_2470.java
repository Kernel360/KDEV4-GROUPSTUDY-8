package youngseok.sorting;

/*
두 용액 - 골드 5 (메모리 초과)

용액을 오름차순으로 정렬
두 용액을 선택하는 완전탐색 진행
두 수의 합의 절대값이 최소가 되는 값을 저장해 반환
0 이 되면 반환
 */

import java.io.*;
import java.util.*;

class Combination3 implements Comparable<Combination3>{
    int potion1;
    int potion2;

    Combination3(int potion1, int potion2){
        this.potion1 = potion1;
        this.potion2 = potion2;
    }

    /*
        두 조합 중 더 작은 값을 나타내는 값을 반환
     */
    @Override
    public int compareTo(Combination3 o) {
        return Integer.compare(Math.abs(this.potion1+this.potion2),Math.abs(o.potion1+o.potion2));
    }
}

public class beakjoon_2470 {
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

        List<Combination3> list = new ArrayList<>();
        for(int i =0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                Combination3 combi = new Combination3(potions[i],potions[j]);
                list.add(combi);
            }
        }

        Collections.sort(list);
        bw.write(list.get(0).potion1 + " " + list.get(0).potion2);
        bw.flush();
        bw.close();
        br.close();
    }
}
