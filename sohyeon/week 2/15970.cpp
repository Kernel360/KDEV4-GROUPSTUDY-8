#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;
    
    vector<vector<int>> v(n+1);
    
    for(int i=0; i<n; i++){
        int a, b;
        cin >> a >> b;
        v[b].push_back(a);
    } 
    
    for(int i=1; i<n+1; i++) sort(v[i].begin(), v[i].end());
    
    
    int sum = 0;
    
    for(int i=1; i<=n; i++){
        
        if (v[i].empty()) continue; 
        
        int diff=v[i][1]-v[i][0];
        sum+=diff;
        for(int j=1; j<v[i].size()-1; j++){
            int diff2 = v[i][j+1]-v[i][j];
            if(diff>diff2) sum+=diff2;
            else sum+=diff;
            diff=diff2;
        }
        sum+=diff;
    }
    
    cout << sum;
    
    
    return 0;
}