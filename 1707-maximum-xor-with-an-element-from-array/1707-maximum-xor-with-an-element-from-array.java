class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        ArrayList<Pair> query = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            query.add(new Pair(queries[i], i)); 
        }
        Collections.sort(query, (x, y) -> x.arr[1] - y.arr[1]);
        Arrays.sort(nums);
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            ans.add(-1);
        }

        int ind = 0; 
        for (int i = 0; i < m; i++) {

            while (ind < n && nums[ind] <= query.get(i).arr[1]) {
                trie.insert(nums[ind++]);
            }

            if (ind != 0) {
                ans.set(query.get(i).ind, trie.getMax(query.get(i).arr[0]));
            } else { 
                ans.set(query.get(i).ind, -1);
            }
        }

        
        int[] sol = new int[m];
        for (int i = 0; i < m; i++) {
            sol[i] = ans.get(i);
        }
        return sol;
    }
}


class TrieNode {
    TrieNode[] links; 
    TrieNode() {
        links = new TrieNode[2]; 
    }
    boolean containsKey(int n) {
        return links[n] != null; 
    }
    TrieNode get(int n) {
        return links[n]; 
    }
    void put(int n, TrieNode node) {
        links[n] = node; 
    }
}

class Trie{
	TrieNode root=new TrieNode(); 
	Trie(){}
	void insert(int num){
		TrieNode node=root;
		for(int i=31;i>=0;i--){ 
			int bit=(num>>i) & 1; 
			if(!node.containsKey(bit)){ 
				node.put(bit, new TrieNode()); 
			}
			node=node.get(bit); 
		}
	}
	int getMax(int num){
		TrieNode node=root;
		int max=0;
		for(int i=31;i>=0;i--){ 
			int bit=(num>>i)&1; 
			if(node.containsKey(1-bit)){ 
				max=max|(1<<i); 
				node=node.get(1-bit);
			}else{
				node=node.get(bit); 
			}
		}
		return max;
	}
}

class Pair{
	int [] arr; 
	int ind; 
	Pair(int []arr,int ind){
		this.arr=arr; 
		this.ind=ind;
	}
} 
