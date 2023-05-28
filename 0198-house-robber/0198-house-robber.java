class Solution {
    
    public int rob(int[] arr) {
    int length =arr.length;
        if(length==1){
              return arr[0];
        }
          
        
        
        int dp[] =new int[length];
        dp[0] =arr[0] ;
        dp[1] =Math.max(arr[0] , arr[1] ) ;
        
        for(int i=2;i<length;i++){
            dp[i] =Math.max(dp[i-1],dp[i-2] +arr[i]);
        }
        
        return dp[length-1];     
}

}



