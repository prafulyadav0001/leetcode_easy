//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
   public static int countFractions(int n, int[] numerator, int[] denominator) {
       
        HashMap<String,Integer> hm= new HashMap<>();
        int res=0;
        
        int a1,a2;
        String s1,s2;
        
        for(int i=0;i<n;i++){
            
            int gcd= getGcd(numerator[i], denominator[i] );
            
            a1=numerator[i]/gcd;
            a2=denominator[i]/gcd;
            
            s1= a1+"/"+a2;
            s2= (a2-a1)+"/"+a2;
            
            if(hm.containsKey(s2)) res += hm.get(s2);

            hm.put(s1, hm.getOrDefault(s1,0)+1);
  
        }
        
        return res;
    }
    
    public static int getGcd(int i, int j){
        
        if(j==0) return i;
        
        else return getGcd(j,i%j);
   
    }
}