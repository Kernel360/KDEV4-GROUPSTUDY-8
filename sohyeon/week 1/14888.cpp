#include <iostream>
#include <climits>

using namespace std;

int n;
int num[101];
int ope[4];
int ma = INT_MIN;
int mi = INT_MAX;

void dfs(int dep, int sum){
    if(dep==n-1){
        if(mi>sum) mi = sum;
        if(ma<sum) ma = sum;
        return;
    }
    for(int i=0; i<4; i++){
        if(ope[i]>0){
            ope[i]--;
            if(i==0) dfs(dep+1, sum+num[dep+1]);
            if(i==1) dfs(dep+1, sum-num[dep+1]);
            if(i==2) dfs(dep+1, sum*num[dep+1]);
            if(i==3) dfs(dep+1, sum/num[dep+1]);
            ope[i]++;
        };
    }
    
    
}

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
	
    //
    cin >> n;
    for(int i=0; i<n; i++) cin >> num[i];
    for(int i=0; i<4; i++) cin >> ope[i];
   
    //
    dfs(0, num[0]);
    cout << ma << endl << mi;
    

    return 0;
}
