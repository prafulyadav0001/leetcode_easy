//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
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
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int[] size;
    private int n;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n + 1];
        size = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        // Path compression
        return parent[a] = findParent(parent[a]);
    }

    public void unionByRank(int a, int b) {
        int uP_a = findParent(a);
        int uP_b = findParent(b);
        if (uP_a == uP_b) return;
        if (rank[uP_a] < rank[uP_b]) {
            parent[uP_a] = uP_b;
        } else if (rank[uP_a] > rank[uP_b]) {
            parent[uP_b] = uP_a;
        } else {
            parent[uP_b] = uP_a;
            rank[uP_a]++;
        }
    }

    public void unionBySize(int a, int b) {
        int uP_a = findParent(a);
        int uP_b = findParent(b);
        if (uP_a == uP_b) return;
        if (size[uP_a] < size[uP_b]) {
            parent[uP_a] = uP_b;
            size[uP_b] += size[uP_a];
        } else {
            parent[uP_b] = uP_a;
            size[uP_a] += size[uP_b];
        }
    }

    public int getSize(int i) {
        return size[i];
    }
}

class Solution {
    private int n;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    private boolean isSafe(int i, int j, int[][] grid) {
        return (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 1);
    }

    private int dfs(DisjointSet ds, int i, int j, int[][] grid) {
        Set<Integer> s = new HashSet<>();
        int sum = 1;

        for (int a = 0; a < 4; a++) {
            int nI = i + dx[a];
            int nJ = j + dy[a];
            if (isSafe(nI, nJ, grid)) {
                s.add(ds.findParent(nI * n + nJ));
            }
        }

        for (int it : s) {
            sum += ds.getSize(it);
        }
        return sum;
    }

    public int largestIsland(int N,int[][] grid) 
    {
       n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        List<int[]> toChange = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int a = 0; a < 4; a++) {
                        int nI = i + dx[a];
                        int nJ = j + dy[a];
                        if (isSafe(nI, nJ, grid)) {
                            if (ds.findParent(i * n + j) != ds.findParent(nI * n + nJ)) {
                                ds.unionBySize(i * n + j, nI * n + nJ);
                            }
                        }
                    }
                } else {
                    toChange.add(new int[]{i, j});
                }
            }
        }

        int largestLandSize = 0;

        for (int i = 0; i < n; i++) {
            largestLandSize = Math.max(largestLandSize, ds.getSize(i));
        }

        for (int[] it : toChange) {
            int i = it[0];
            int j = it[1];
            largestLandSize = Math.max(largestLandSize, dfs(ds, i, j, grid));
        }

        return largestLandSize;
        
    }
}