#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int get_percent(long long x, long long y) {
	long long percent = y * 100 / x;
	
	return percent;
}

int main() {
	int x, y;

	cin >> x >> y;

	int z = get_percent(x, y);

	bool flag = false;

	int start = 1;
	int end = 1000000000;
	int count; 
	while (start <= end) {
		count = (start + end) / 2;

		int next_z = get_percent(x + count, y + count);
		if (next_z > z) {
			end = count - 1;
		} else if (next_z <= z) {
			start = count + 1;
		}
	}

	if (start == 1000000001) {
		cout << -1;
	} else {
		cout << start << endl;
	}
}
