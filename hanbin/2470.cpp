#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N;

int arr[100001];

int answer[2];

int main() {
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> arr[i];
	}

	sort(arr, arr + N);

	int start = 0;
	int end = N - 1;

	int min_start = 0;
	int min_end = N - 1;
	int min_value = abs(arr[start] + arr[end]);

	answer[0] = arr[min_start];
	answer[1] = arr[min_end];
	
	while (start < end) {
		int mid = arr[start] + arr[end];

		if (abs(mid) < abs(min_value)) {
			min_start = start;
			min_end = end;
			min_value = mid;
			answer[0] = arr[min_start];
			answer[1] = arr[min_end];

			if (mid == 0) {
				break;
			}
		}

		if (mid < 0) {
			start += 1;
		} else {
			end -= 1;
		}
	}

	sort(answer, answer + 2);
	cout << answer[0] << " "  << answer[1];
}

