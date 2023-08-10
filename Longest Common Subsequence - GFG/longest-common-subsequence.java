//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int arr[][] = new int[x+1][y+1];
        for(int i=x; i>=0;i--){
            for(int j=y; j>=0; j--){
                if(i==x|| j==y){
                    arr[i][j]=0;
                }
                else if(s1.charAt(i)==s2.charAt(j)){
                    arr[i][j]= 1 + arr[i+1][j+1];
                }
                else if(s1.charAt(i)!=s2.charAt(j)){
                    arr[i][j] = Math.max(arr[i][j+1],arr[i+1][j]);
                }
            }
        }
        return arr[0][0];
    }
    
}