#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N, C;
vector<int> house;

bool can_fill_house(int space) {
	int count = 1;
	int last = house[0];

	for (int i = 1; i < house.size(); ++i) {
		if (house[i] - last >= space) {
			count += 1;
			last = house[i];
		}
	}
	return count >= C;
}

int main() {
	cin >> N >> C;

	for (int i = 0; i < N; ++i) {
		int n;
		cin >> n;

		house.push_back(n);
	}
	sort(house.begin(), house.end());

	int start = 1;
	int end = 1000000000;

	int max_space = 1;

	while (start <= end) {
		int mid = (start + end) / 2;

		if (can_fill_house(mid)) {
			max_space = max(max_space, mid);
			start = mid + 1;
		} else {
			end = mid - 1;
		}
	}
	cout << max_space << "\n";
}

