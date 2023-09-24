//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
            Arrays.sort(arr);
             LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i:
             map.keySet()) {
            if(map.get(i)>1){
                arrayList.add(i);
            }
        }
        if(arrayList.size()==0 ){
            arrayList.add(-1);
          
        }
        return arrayList;
    }
}
