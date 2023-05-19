//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends

class Pair implements Comparable<Pair> {
    
    int i;
    int j;
    
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
    
    public int compareTo(Pair s){
        return this.i- s.i;
    }
}
class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        
        List<Pair> ls= new ArrayList<>();
        for(int i=0;i<range.length;i++){
            ls.add(new Pair(range[i][0],range[i][1]));
        }
        
        Collections.sort(ls);
        
    ArrayList<Pair> mrg= new ArrayList<>(); // this is for merging list
        mrg.add(ls.get(0));
        
            for(int m=1;m<ls.size();m++){
               if(ls.get(m).i<=mrg.get(mrg.size()-1).j){
                   
                   int ri=mrg.get(mrg.size()-1).i;
                   int rj= Math.max(ls.get(m).j,mrg.get(mrg.size()-1).j);
                   
                   mrg.remove(mrg.size()-1);
                   mrg.add(new Pair(ri,rj));
               }
               else mrg.add(new Pair(ls.get(m).i,ls.get(m).j));
            }
            
            
        ArrayList<Integer> strd= new ArrayList<>();
        for(int itr=0;itr<q;itr++){
            int prevcount =0;
            for(int m=0;m<mrg.size();m++){
               if(queries[itr]>mrg.get(m).j-mrg.get(m).i+1 +prevcount){
                   prevcount +=mrg.get(m).j-mrg.get(m).i+1;
                   continue;
               } 
               
               strd.add(mrg.get(m).i + (queries[itr]-prevcount-1));
               break;
               
               
            }
            if(strd.size()!=itr+1) strd.add(-1);
        }
        return strd;
        
    }
}