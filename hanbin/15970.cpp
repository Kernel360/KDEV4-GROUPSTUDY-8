#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N;

vector<vector<int>> arr;

long long get_distance(vector<int> vec) {
	long long sum = 0;

	for (int i = 0; i < vec.size(); ++i) {
		long long min_value;

		if (i == 0) {
			min_value = vec[i + 1] - vec[i];
		} else if (i == vec.size() - 1) {
			min_value = vec[i] - vec[i - 1];
		} else {
			min_value = min(vec[i + 1] - vec[i], vec[i] - vec[i - 1]);
		}

		sum += min_value;
	}

	return sum;
}

int main() {
	cin >> N;

	for (int i = 0; i <= N; ++i) {
		arr.push_back(vector<int>());
	}

	for (int i = 0; i < N; ++i) {
		int dot, color;
		cin >> dot >> color;

		arr[color].push_back(dot);
	}

	for (int i = 0; i <= N; ++i) {
		sort(arr[i].begin(), arr[i].end());
	}

	long long sum = 0;

	for (int i = 0; i <= N; ++i) {
		sum += get_distance(arr[i]);
	}

	cout << sum;
}

