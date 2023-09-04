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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int [][]vis = new int[n][m];
        int [][]temp = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1 ){
                    if(a[i][j] == 'O' && vis[i][j] == 0){
                        queue.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                   
                }
            }
        }
        // System.out.println(queue);
        int [] delrow = {-1, 0, +1, 0};
        int [] delcol = {0, +1, 0, -1};
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            for(int i=0; i<4; i++){
                int nrow = p.row + delrow[i];
                int ncol = p.col + delcol[i];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && a[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        char [][] ans = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && a[i][j] == 'O') a[i][j] = 'X';
                
            }
        }
        return a;
    }
}