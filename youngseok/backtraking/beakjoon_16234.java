package youngseok.backtraking;

import java.io.*;
import java.util.*;

public class beakjoon_16234 {
    static int n, L, R;
    static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        bw.write(String.valueOf(solution(a)));
        bw.flush();
    }

    public static int solution(int[][] land) {
        int days = 0;

        while (true) {
            boolean[][] isOpened = openCheck(land);
            if (openCnt(isOpened) == 0) {
                break; // 국경이 열리지 않으면 종료
            }
            land = move(land, isOpened); // 인구 이동
            days++;
        }

        return days;
    }

    // 국경 확인 함수
    public static boolean[][] openCheck(int[][] land) {
        boolean[][] isOpened = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newY = i + dxy[k][0];
                    int newX = j + dxy[k][1];

                    if (newY >= 0 && newY < n && newX >= 0 && newX < n) {
                        int diff = Math.abs(land[i][j] - land[newY][newX]);
                        if (diff >= L && diff <= R) {
                            isOpened[i][j] = true;
                            isOpened[newY][newX] = true;
                        }
                    }
                }
            }
        }

        return isOpened;
    }

    // 국경 오픈 갯수 확인 함수
    public static int openCnt(boolean[][] land) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j]) cnt++;
            }
        }
        return cnt;
    }

    // 인구 이동 함수
    public static int[][] move(int[][] land, boolean[][] isOpened) {
        boolean[][] visited = new boolean[n][n];
        int[][] resultLand = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(land[i], 0, resultLand[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    List<int[]> union = bfs(i, j, land, visited);
                    if (union.size() > 1) { // 연합이 형성된 경우
                        int totalPopulation = union.stream().mapToInt(pos -> land[pos[0]][pos[1]]).sum();
                        int avgPopulation = totalPopulation / union.size();

                        for (int[] pos : union) {
                            resultLand[pos[0]][pos[1]] = avgPopulation;
                        }
                    }
                }
            }
        }

        return resultLand;
    }

    // BFS로 연합 찾기
    public static List<int[]> bfs(int y, int x, int[][] land, boolean[][] visited) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x});
        union.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];

            for (int k = 0; k < 4; k++) {
                int newY = curY + dxy[k][0];
                int newX = curX + dxy[k][1];

                if (newY >= 0 && newY < n && newX >= 0 && newX < n && !visited[newY][newX]) {
                    int diff = Math.abs(land[curY][curX] - land[newY][newX]);
                    if (diff >= L && diff <= R) { // 국경 조건 만족
                        queue.add(new int[]{newY, newX});
                        union.add(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }
        }

        return union;
    }
}
