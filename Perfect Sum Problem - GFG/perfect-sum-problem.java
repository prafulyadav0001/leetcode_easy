//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    static int mod=(int)1e9+7;
 
public int perfectSum(int arr[],int n, int sum) 
{  
    int dp[][]=new int[n+1][sum+1];
    for(int row[]:dp){
        Arrays.fill(row,-1);
    }
    
    int count=0;
    count+=f(0,count,arr,n,sum,dp);
    return count;
    
} 
static int f(int idx,int count,int arr[],int n, int sum,int dp[][]){
    if(idx==n){
        if(sum==0){
            return 1;
        }else{
            return 0;
        }
    }
    if(dp[idx][sum]!=-1)return dp[idx][sum];
    int take=0;
    if(arr[idx]<=sum){
        take=f(idx+1,count,arr,n,sum-arr[idx],dp);
    }
    int nottake=f(idx+1,count,arr,n,sum,dp);
    
    return dp[idx][sum]=(take+nottake)%mod;
}
}