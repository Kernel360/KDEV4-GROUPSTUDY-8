#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <cmath>

using namespace std;

int N,L,R;

int A[200][200];
bool visited[200][200];
bool flag;

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

bool open_country(int n, int m) {
	int diff = abs(n - m);

	if (diff >= L && diff <= R) {
		return true;
	}
	return false;
}

void dfs(int y, int x, vector<tuple<int, int, int>> &country) {
	if (visited[y][x]) {
		return ;
	}
	country.push_back({y, x, A[y][x]});

	visited[y][x] = true;

	for (int i = 0; i < 4; ++i) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
			continue;
		}
		if (visited[ny][nx]) {
			continue;
		}
		if (!open_country(A[y][x], A[ny][nx])) {
			continue;
		}
		flag = true;
		dfs(ny, nx, country);
	}
}

void people_can_move(vector<vector<tuple<int, int, int>>> &country) {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (visited[i][j]) {
				continue;
			}
			dfs(i, j, country[country.size() - 1]);
			country.push_back(vector<tuple<int, int, int>>());
		}
	}
}

void people_move(vector<vector<tuple<int, int, int>>> &country) {
	for (int i = 0; i < country.size(); ++i) {
		int sum = 0;
		for (int j = 0; j < country[i].size(); ++j) {
			auto [y, x, count] = country[i][j];
			sum += count;
		}
		if (country[i].size() <= 0) {
			continue;
		}
		int avg = sum / country[i].size();

		for (int j = 0; j < country[i].size(); ++j) {
			auto [y, x, count] = country[i][j];
			A[y][x] = avg;
		}
	}
}

int main() {
	cin >> N >> L >> R;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cin >> A[i][j];
		}
	}

	int move_count = 0;
	while (true) {
		memset(visited, 0, sizeof(visited));
		vector<vector<tuple<int, int, int>>> country; 
		country.push_back(vector<tuple<int, int, int>>());

		flag = false;
		people_can_move(country);

		if (!flag) {
			break;
		}

		people_move(country);
		++move_count;
	}
	cout << move_count;
}
