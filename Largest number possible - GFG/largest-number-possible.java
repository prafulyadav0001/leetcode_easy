//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        
        String ans ="";
        if((S==0 && N>1) || (S!=0 && N==0))
            return "-1";
        if(S>9*N)
            return "-1";
        if(N==1){
            return Integer.toString(S);
        }
        int dig = 9;
        while(N>0){
            while(S-dig<0)
                dig--;
            ans+= Integer.toString(dig);
            S-=dig;
            N--;
        }
        if(S==0 && N==0)
            return ans;
        else
            return "-1";
    }
}