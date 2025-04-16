package youngseok.bfs;

/*
보물섬 - 골드 5

육지 : L
바다 : W

이동은 상하좌우로 이웃한 육지로만 가능
한칸 이동하는데 한시간
보물은 서로간에 최단거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두곳에 나뉘어 묻혀있다.

풀이

BFS 탐색
탐색 거리가 가장 긴 곳이 보물이 묻혀있는 곳
최장 탐색 거리를 찾으면 된다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class beakjoon_2589 {

	static int maxDepth = -1;
	static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
	static char[][] map;
	static boolean[][] visited;

	private static void solution(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y, x, 0});
		visited[y][x] = true;

		while(!q.isEmpty()){
			int[] curr = q.poll();
			int currY = curr[0];
			int currX = curr[1];
			int currD = curr[2];

			if(currD > maxDepth){
				maxDepth = currD;
			}

			for (int i = 0; i < 4; i++) {
				int newX = currX + dxy[i][1];
				int newY = currY + dxy[i][0];

				if (newX >= 0 && newX < map[0].length && newY >= 0 && newY < map.length) {
					if (map[newY][newX] == 'L' && !visited[newY][newX]) {
						visited[newY][newX] = true;
						q.add(new int[] {newY,newX, currD +1});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());

		map = new char[y][x];
		for (int i = 0; i < y; i++) {
			String newLine = br.readLine();
			for (int j = 0; j < x; j++) {
				map[i][j] = newLine.charAt(j);
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[y][x];
					solution(j, i);
				}
			}
		}

		bw.write(String.valueOf(maxDepth));
		bw.flush();
		bw.close();
		br.close();
	}
}
