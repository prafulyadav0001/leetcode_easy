class Solution {
    public int arraySign(int[] nums) {
        int n= nums.length;
        int b=1;
        
        for (int i=0;i<n;i++){
           if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                b = -1 * b;
            }

        }
       
     
          return b;


    }
}