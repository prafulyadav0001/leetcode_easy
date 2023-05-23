class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int i = 0; i < nums.length; i++){
            int j = random.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}