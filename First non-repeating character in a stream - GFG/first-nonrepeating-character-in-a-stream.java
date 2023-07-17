//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
       HashMap<Character,Integer> map = new HashMap<>();
       
       List<Character> que = new ArrayList<>();
       int n = 0;
       StringBuilder sb = new StringBuilder();
       for(int i = 0 ; i < A.length() ; i++){
           char ch = A.charAt(i);
           
           if(map.containsKey(ch)){
            map.put(ch,-1);
           }
           else{
               map.put(ch,que.size());
               que.add(ch);
           }
           
           if(que.size() == 0) sb.append('#');
           else {
             
               while(n < que.size() && (int)map.get(que.get(n)) == -1) n++;
               if(n < que.size()) sb.append(que.get(n));
               else sb.append('#');
           }
       }
       
       return sb.toString();
    }
}