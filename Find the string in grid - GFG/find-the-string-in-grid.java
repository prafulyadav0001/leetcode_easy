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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        int n = grid.length;
        int m = grid[0].length;
        int wordLen = word.length();
        
        List<int[]> result = new ArrayList<>();
        
        // Define the eight possible directions (dx, dy)
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
        
        // Iterate through the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // If the current cell matches the first character of the word, try all directions
                if (grid[i][j] == word.charAt(0)) {
                    
                    // Check each direction
                    for (int dir = 0; dir < 8; dir++) {
                        int x = i;
                        int y = j;
                        int index = 0;
                        
                        // Check if the word can be formed in this direction
                        while (index < wordLen && x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == word.charAt(index)) {
                            x += dx[dir];
                            y += dy[dir];
                            index++;
                        }
                        
                        // If the entire word is found, add the starting position
                        if (index == wordLen) {
                            result.add(new int[]{i, j});
                            break; // Exit the direction loop
                        }
                    }
                }
            }
        }
        
        // Convert the list of results to a 2D array
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
