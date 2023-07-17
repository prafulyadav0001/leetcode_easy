class Solution {
    public boolean canJump(int[] arr) {
        int n=arr.length;
        boolean dp[] =new boolean [n];
        for (int i=0;i<n;i++){
            dp[i]=false;
        }
        
        int lmt=0;
        for(int i=0;i<n;i++){
            if(i<=lmt){
            dp[i]=true;
                lmt=Math.max(lmt,arr[i]+i);
                if(lmt>=n-1)
                    return true;
            }
          
        }
        return false;
    }
        }