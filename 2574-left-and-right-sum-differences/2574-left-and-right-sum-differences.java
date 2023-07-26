class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left[] =new int[nums.length];
        int right[]=new int[nums.length];

        int sumleft=0;
        int sumright =0;
        int length =nums.length-1;
        for(int i=0;i<=length;i++){
            left[i]=sumleft;
            right[length-i]=sumright;
            sumleft+=nums[i];
            sumright+=nums[length-i];
        }
        for(int i=0;i<=length;i++){
            nums[i]=Math.abs(left[i]-right[i]);
        }
        return nums;


        
    }
}