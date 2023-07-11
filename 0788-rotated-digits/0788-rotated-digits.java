class Solution {
    public int rotatedDigits(int n) {
        int cnt=0, r=0;
       for(int i=1;i<=n;i++){
           int k=i;
           while(k!=0){
               int rem=k%10;
if(rem==2||rem==5||rem==6||rem==9){
    r=1;
} if(rem==3||rem==4||rem==7){
    r=0;break;
}k/=10;
           }
           if(r==1){
               cnt++;
           }r=0;
       }
        return cnt;
    }
}