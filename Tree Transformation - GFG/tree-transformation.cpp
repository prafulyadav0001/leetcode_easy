//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
    public:
    int ans=0;
    void run(vector<vector<int>>&g,int i,int p){
        for(auto it:g[i]){
            if(it!=p){
                if(g[it].size()>1) ans++,run(g,it,i);
            }
        }
    }
    int solve(int N, vector<int> p){
        vector<int>q(N);
        for(int i=1;i<N;i++) q[i]++,q[p[i]]++;
        int curr=0,maxi=q[0];
        for(int i=1;i<N;i++){
            if(q[i]>maxi) curr=i,maxi=q[i];
        }
        vector<vector<int>>g(N);
        for(int i=1;i<N;i++) g[i].push_back(p[i]),g[p[i]].push_back(i);
        run(g,curr,-1);
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int T;
    cin >> T;
    while(T--){
        int N;
        cin >> N;
        vector<int> p(N);
        for(int i = 0; i < N; i++){
            cin >> p[i];
        }

        Solution obj;
        cout << obj.solve(N, p) << "\n";
    }
}   
// } Driver Code Ends