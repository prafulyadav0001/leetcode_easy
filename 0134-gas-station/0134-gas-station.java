class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {//        int i=0;
    int total=0;
        int cur=0;
        int s=0;
        for (int i=0;i< cost.length;i++){
            total+=(gas[i]-cost[i]);
            cur+=(gas[i]-cost[i]);
            if (cur<0){
                cur=0;
                s=i+1;
            }
        }
        if (total<0){
            return -1;
        }
        return s;
    }
}