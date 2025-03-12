#include <cstring>
#include <vector>
#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>

using namespace std;

vector<int> graph[101];
bool visited[101];

int elem_count;

void search(int cur) {
    ++elem_count;
    visited[cur] = true;
    
    for (int next : graph[cur]) {
        if (!visited[next]) {
            search(next);
        }
    }
}

int solution(int n, vector<vector<int>> wires) {
    int answer = INT_MAX;
    
    for (vector<int> wire: wires) {
        int v1 = wire[0];
        int v2 = wire[1];
        graph[v1].push_back(v2);
        graph[v2].push_back(v1);
    }
    
    for (vector<int> wire: wires) {
        memset(visited, 0, sizeof(visited));
        
        int v1 = wire[0];
        int v2 = wire[1];
        
        graph[v1].erase(find(graph[v1].begin(), graph[v1].end(), v2));
        graph[v2].erase(find(graph[v2].begin(), graph[v2].end(), v1));
            
        elem_count = 0;
        search(v1);
        int v1_result = elem_count;
        
        elem_count = 0;
        search(v2);
        int v2_result = elem_count;
        
        answer = min(abs(v1_result - v2_result), answer);
        
        graph[v1].push_back(v2);
        graph[v2].push_back(v1);
    }
    return answer;
}
