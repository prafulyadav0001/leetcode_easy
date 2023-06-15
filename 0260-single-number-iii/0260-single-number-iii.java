class Solution {
    public int[] singleNumber(int[] arr) {
        int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = ans ^ arr[i];
		}
		int mask = (ans & (~(ans - 1)));
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((mask & arr[i]) != 0) {
				a ^= arr[i];
			}
		}
		int b = ans ^ a;
        int [] ar={a,b};
        return ar;
    }
}