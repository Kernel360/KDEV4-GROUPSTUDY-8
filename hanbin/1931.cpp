#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <stack>

using namespace std;

int N;

vector<pair<int, int>> arr;

int main() {
	cin >> N;

	for (int i = 0; i < N; ++i) {
		int start, end;

		cin >> start >> end ;
		arr.push_back({start, end});
	}

	sort(arr.begin(), arr.end());

	stack<pair<int, int>> room;
	room.push(arr[0]);

	for (int i = 1; i < N; ++i) {
		auto [cur_start, cur_end] = room.top();
		auto [next_start, next_end] = arr[i];

		if (cur_end > next_end) {
			//cout << "빼고넣기 : " ;
			//cout << cur_start << " " << cur_end << " " << next_start << " " << next_end << "\n";
			room.pop();
			room.push(arr[i]);
			continue ;
		}

		if (next_end >= cur_start && next_start >= cur_end) {
			//cout << "그냥넣기 : " ;
			//cout << cur_start << " " << cur_end << " " << next_start << " " << next_end << "\n";
			room.push(arr[i]);
		}
	}

	cout << room.size();
}

