//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String swap(String s , int a , int b){
        StringBuilder sb = new StringBuilder(s);
        //char temp = s.charAt(a);
        sb.setCharAt(b,s.charAt(a));
        sb.setCharAt(a,s.charAt(b));
        return sb.toString();
    }
    public void permute(String s , ArrayList<String> arr , int l , int r){
        if(l == r){
            arr.add(s);
            return;
        }
        for(int i=l;i<=r;i++){
            s = swap(s,l,i);
            permute(s,arr,l+1,r);
            s = swap(s,l,i);
        }
    }
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ans = new ArrayList<>();
        permute(S,ans,0,S.length()-1);
        Collections.sort(ans);
        return ans;
    }
	   
}