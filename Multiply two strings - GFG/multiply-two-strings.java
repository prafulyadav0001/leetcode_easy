//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   public String multiplyStrings(String s1,String s2)
    {
        //code here.
      
        boolean negative1=false;
        boolean negative2=false;
        if(s1.charAt(0)=='-'){
            s1=s1.substring(1,s1.length());
            negative1=true;
        }
        if(s2.charAt(0)=='-'){
            s2=s2.substring(1,s2.length());
            negative2=true;
        }
        int n1=s1.length();
        int n2=s2.length();
        int[] res=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            int digit1=s1.charAt(i)-'0';
            for(int j=n2-1;j>=0;j--){
                int digit2=s2.charAt(j)-'0';
                int sum=digit1*digit2+res[i+j+1];
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int temp:res){
            sb.append(temp);
        }
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(negative1==true && negative2==true){
            return sb.toString();
        }
        if(negative1==true || negative2==true){
            if(sb.length()>0){
                sb.insert(0,'-');
            }
            return sb.length()==0?"0":sb.toString();
        }
        return sb.length()==0? "0":sb.toString();
    }
}