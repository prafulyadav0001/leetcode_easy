class Solution {
    int[] dp;
    public int climbStairs(int n) {
       dp=new int[n+1];
        
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        
      return  recursionbabu(n);
    }
    
    public int recursionbabu(int n)
    {
        if(dp[n]==-1){
             int lund;
        if( n==0 || n==1 || n==2){
        lund=n;
        }
        else{
            lund=recursionbabu(n-1)+recursionbabu(n-2);
        }
        dp[n]=lund;
        }
       
    return dp[n];
    }
    
  
}