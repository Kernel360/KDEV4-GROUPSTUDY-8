#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <cmath>

using namespace std;

int n;
int arr[200];
int oper[4];

int max_value = INT_MIN;
int min_value = INT_MAX;

void recur(int num, int depth) {
	if (depth == n) {
		max_value = max(max_value, num);
		min_value = min(min_value, num);
		return;
	}
	int sum = 0;

	for (int i = 0; i < 4; ++i) {
		if (oper[i] == 0) {
			continue;
		}
		if (i == 0) {
			sum = num + arr[depth];
		}
		if (i == 1) {
			sum = num - arr[depth];
		}
		if (i == 2) {
			sum = num * arr[depth];
		}
		if (i == 3) {
			sum = num / arr[depth];
		}
		oper[i] -= 1;
		recur(sum, depth + 1);
		oper[i] += 1;
	}
}

void solution() {
	recur(arr[0], 1);
	cout << max_value << "\n";
	cout << min_value << "\n";
}

int main() {
	cin >> n;
	
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
	}

	for (int i = 0; i < 4; ++i) {
		cin >> oper[i];
	}
	solution();
}

