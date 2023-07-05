class Solution {
    public int findMaximumXOR(int[] nums) {
	var trie = new Trie();
	Arrays.stream(nums)
		  .forEach(trie::insert);

	var max = 0;
	for (var num : nums)
		max = Math.max(max, num ^ trie.query(Integer.MAX_VALUE ^ num));
	return max;
}

private static class Trie {

	private static final int[] MASKS = new int[31];
	private static class Node {
		private Node zero;
		private Node one;
	}
	
	private final Node root = new Node();
	
	static {
		IntStream.range(0, 31)
				 .forEach(i -> MASKS[i] = 1 << i);
	}

	public Trie() {}

	public void insert(int n) {
		var bitIndex = 30;
		var current = root;

		while (bitIndex >= 0) {
			var bit = (MASKS[bitIndex--] & n) == 0 ? 0 : 1;

			if (bit == 0) {
				if (current.zero == null)
					current.zero = new Node();
				current = current.zero;
			} else {
				if (current.one == null)
					current.one = new Node();
				current = current.one;
			}
		}
	}

	private int query(int n) {
		var bitIndex = 30;
		var current = root;
		var result = 0;

		while (bitIndex >= 0) {
			var bit = (n & MASKS[bitIndex]) == 0 ? 0 : 1;

			if (bit == 0) {
				if (current.zero == null) {
					current = current.one;
					result |= MASKS[bitIndex];
				} else {
					current = current.zero;
				}
			} else {
				if (current.one == null) {
					current = current.zero;
				} else {
					current = current.one;
					result |= MASKS[bitIndex];
				}
			}

			bitIndex--;
		}

		return result;
	}
}
}