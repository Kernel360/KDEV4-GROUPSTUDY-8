#include <iostream>
#include <vector>
#include <cstring> 

using namespace std;

int n, l, r;
int population[51][51];
bool visited[51][51];
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};
vector<pair<int, int>> unionList; 

int dfs(int x, int y) {
    visited[x][y] = true;
    unionList.push_back({x, y});
    int sum = population[x][y];

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
            int diff = abs(population[x][y] - population[nx][ny]);
            if (diff >= l && diff <= r) { 
                sum += dfs(nx, ny);
            }
        }
    }
    return sum;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> l >> r; 
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> population[i][j];

    int days = 0;
    while (true) {
        bool moved = false;
        memset(visited, false, sizeof(visited));  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { 
                    unionList.clear();
                    int totalPop = dfs(i, j);
                    int size = unionList.size();

                    if (size > 1) {
                        moved = true;
                        int newPop = totalPop / size;
                        for (auto &p : unionList)
                            population[p.first][p.second] = newPop;
                    }
                }
            }
        }

        if (!moved) break; 
        days++;
    }

    cout << days; 
    return 0;
}
