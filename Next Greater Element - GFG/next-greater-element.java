//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        long res[] = new long[n];
        Stack<Long> s = new Stack<Long>();
        res[n-1] = -1;
        s.push(arr[n-1]);
        
        for(int i=n-2;i>=0;i--)
        {
            while(s.isEmpty()==false && s.peek()<=arr[i])
                s.pop();
            if(s.isEmpty())
                res[i] = -1;
            else
                res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    } 
}