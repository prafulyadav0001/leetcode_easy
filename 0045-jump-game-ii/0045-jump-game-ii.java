class Solution {
public int jump(int[] arr) {
	int jump = 0, cur = 0, lt = 0;
	for(int i=0;i<arr.length-1;i++)
    {
       lt=Math.max(lt,arr[i]+i);
        
        if(cur==i){
            jump++;
            cur=lt;
        }
    }
    return jump;
}
    
}