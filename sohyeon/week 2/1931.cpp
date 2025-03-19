#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;



int main()
{
    int n;
    cin >> n;
    
    vector<pair<int, int>> input(n);
    for(int i=0; i<n; i++)
      cin >> input[i].second >> input[i].first; //first, second = 끝나는 시간, 시작 시간
      
    
    sort(input.begin(), input.end());
    
    
    pair<int, int> sc = input[0];
    int result=1;
    
    for(int i=1; i<n; i++){
      if(input[i].second>=sc.first){
        sc=input[i];
        result++;
      }
    }
    
    cout << result;

    
    
    
    
    return 0;
}