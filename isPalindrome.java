class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int temp =x;
        while (x != 0) {
            int rem = x % 10;
            sum = (sum * 10) + rem;
            x = x / 10;
        }
        if(temp<0)
            return false;

        else if(temp == sum)
            return true;

        else
            return false;

    }
        public static void main (String[]args){
            Solution i = new Solution();
            System.out.println(i.isPalindrome(121));
        }

}










//import java.util.Scanner;
//
//public class isPalindrome {
//    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        int x=in.nextInt();
//        int sum=0;
//        while(x!=0){
//            int rem=x%10;
//            sum=(sum*10)+rem;
//            x=x/10;
//        }
//        System.out.println(sum);
//    }
//}
