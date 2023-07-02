class Solution {
    public int longestValidParentheses(String s) {
        
        char[] a = s.toCharArray();
        int n = a.length;
        char[] co = new char[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(a[i] == ')'){
                if(dq.size() > 0) {
                    co[i] = 'C';
                    co[dq.pollLast()] = 'C';
                }
            }
            else{
                dq.offerLast(i);
            }
        }
       // System.out.println(co);
        int res = 0;
        int tmp = 0;
        for(int i = 0; i < n; i++){
            if(co[i] == 'C') tmp++;
            else{
                res = Math.max(res, tmp);
                tmp = 0;
            }
        }
        return Math.max(res, tmp);
    }
}