#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

bool is_prime(int k) {
	int n = 2;

	while (n * n <= k) {
		if (k % n == 0) {
			return false;
		}
		n += 1;
	}

	return true;
}

int get_prev_prime(int k) {
	while (true) {
		if (is_prime(k)) {
			return k;
		}
		--k;
	}
	return k;
}

int get_next_prime(int k) {
	while (true) {
		if (is_prime(k)) {
			return k;
		}
		++k;
	}
	return k;
}

void solution(int k) {
	if (is_prime(k)) {
		cout << "0" << "\n";
		return;
	}

	int prev_prime = get_prev_prime(k);
	int next_prime = get_next_prime(k);

	cout << next_prime - prev_prime << "\n";
}

// 방법 1. 에라스토테네스의 체 이용해서, 소수 모두 구한 후 해당 수의 사이 숫자 어떻게 어떻게 구해보기
// 방법 2. n * n 까지만 탐색하면 소수가 아니라는거 판별되는 방식 이용해서 구해보기
// 방법 2는 테스트케이스가 적어서 ㄱㅊ은듯.. 최적화 한다면 메모이제이션 꾸겨넣으면 될지도?

int main() {
	int T;
	cin >> T;

	for (int i = 0; i < T; ++i) {
		int k;
		cin >> k;

		solution(k);
	}
}

