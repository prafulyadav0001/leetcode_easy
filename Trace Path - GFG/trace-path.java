//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
 
        int lmax=0,rmax=0;
        int umax=0,dmax=0;
        int x=0;
        int y=0;
        
        for(int i=0;i<s.length();i++){
            
            char c= s.charAt(i);
            
            if(c=='L') y--;
            else if(c=='R')y++;
            else if(c=='D')x--;
            else x++;
            
            if(y<lmax) lmax=y;
            if(y>rmax) rmax=y;
            if(x<dmax) dmax=x;
            if(x>umax) umax=x;
            
            
        }
        if(rmax-lmax +1 <=m && umax-dmax +1 <= n) return 1;
        return 0;
    }
}