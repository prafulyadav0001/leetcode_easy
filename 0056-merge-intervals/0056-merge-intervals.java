class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        LinkedList<int[]> mer=new LinkedList<>();
        
        for(int [] interval : intervals){
            if(mer.isEmpty() || mer.getLast()[1]<interval[0])
            {
                mer.add(interval);
            }
            else{
                mer.getLast()[1]=Math.max(mer.getLast()[1],interval[1]);
            }
        }
        return mer.toArray(new int[mer.size()][] );
    }
}