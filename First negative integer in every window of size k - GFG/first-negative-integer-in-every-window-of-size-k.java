//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Compute {
    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
        long[] ans = new long[n-k+1];
        Queue<Integer> negIndex = new LinkedList<>();
        int i = 0, j = 0, indAns = 0;
        while (j < n) {
            if (a[j] < 0) {
                negIndex.add(j);
            }
            if (j+1 < k) {
                j++;
                continue;
            }
            if(!negIndex.isEmpty()){
                if(negIndex.peek()<i) {
                    negIndex.remove();
                }
                if(!negIndex.isEmpty()) {
                    ans[indAns] = a[negIndex.peek()];
                }
            }
            i++;
            j++;
            indAns++;
        }
        return ans;
    }
}