class Solution {
    public String longestPrefix(String str) {
          int dp[] =new int[str.length()];
        int len=0;
        
        for(int i=1;i<str.length();)
        {
           if(str.charAt(len)==str.charAt(i)){
               len++;
               dp[i]=len;
               i++;
           }
            else{
                if(len>0){
                    len=dp[len-1];
                }
                else{
                     dp[i]=len;
                    i++;
                }
                
            }
        }

        return str.substring(0,dp[dp.length-1]);
    }
}