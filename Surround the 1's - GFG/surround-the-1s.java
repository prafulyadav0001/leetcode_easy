//{ Driver Code Starts
//Initial Template for Java

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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int count=0;
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,-1,-1,-1,0,1,1,1};
        int x = matrix.length;
        int y = matrix[0].length;
        for(int row=0; row<matrix.length; row++) {
            for(int col=0; col<matrix[row].length; col++){
                if(matrix[row][col] == 1){
                    int zerosCount = 0;
                    for(int idx=0; idx<8; idx++){
                        int newRow = row+dx[idx];
                        int newCol = col+dy[idx];
                        if(isValid(x, y , newRow, newCol) && matrix[newRow][newCol] == 0){
                            zerosCount++;
                        }
                    }
                    if(zerosCount != 0 && zerosCount%2 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean isValid(int row, int col,int x,int y){
        return x >= 0 && x < row && y>=0 && y < col;
    }
}