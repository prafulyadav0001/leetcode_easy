class Solution {
    public boolean isPalindrome(int x) {
     
        int sum=0;
           int t=x;
        while(x!=0){
            int rem=x%10;
            sum = (sum*10)+rem;
            x=x/10;
        }
        if(t<0)
            return false;
        else if(t==sum)
            return true;
        else
            return false;
    }
}
//  int sum = 0;
//         int temp =x;
//         while (x != 0) {
//             int rem = x % 10;
//             sum = (sum * 10) + rem;
//             x = x / 10;
//         }
//         if(temp<0)
//             return false;
            
//         else if(temp == sum)
//             return true;
        
//         else
//             return false;